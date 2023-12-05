package servidor;

import Control.ClientSocket;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Pichau
 */
public class ChatServer {

    public static final int PORT = 4000;
    private ServerSocket serverSocket;
    private List<ClientSocket> clientes = new LinkedList<>();
    private Set<Integer> numerosSorteados;
    private boolean temVencedor = false;
    private Timer timer;
    private Timer restartTimer;

    public void start() throws IOException {
        System.out.println("Servidor iniciando na porta " + PORT);
        serverSocket = new ServerSocket(PORT);
        clientConnectionLoop();
    }

    private void clientConnectionLoop() throws IOException {        
        while (true) {
            ClientSocket clientSocket = new ClientSocket(serverSocket.accept());
            clientes.add(clientSocket);
            new Thread(() -> clientMessageLoop(clientSocket)).start();
            
            startTimer();
            
        }
    }

    private void clientMessageLoop(ClientSocket clientSocket) {
        String msg;

        try {
            while ((msg = clientSocket.getMessage()) != null) {
                if ("sair".equalsIgnoreCase(msg)) {
                    return;
                }

                System.out.printf("Msg recebida do cliente %s: %s\n", clientSocket.getRemoteSocketAddress(), msg);
                //sendMsgToAll(clientSocket, msg);

                // Verifica se a mensagem "ganhou" foi recebida
                if ("ganhou".equalsIgnoreCase(msg)) {
                    temVencedor = true;
                    numerosSorteados.clear();
                    System.out.println("tem vencedor: " + temVencedor);
                    msg = "Vencedor: " + clientSocket.getRemoteSocketAddress() + "!";
                    sendMsgToAll(clientSocket, msg);

                    restartTimer = new Timer();
                    restartTimer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            restartTimerCycle();
                        }
                    }, 60000);

                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            clientSocket.close();
        }
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("entrou no timer");
                if (clientes.isEmpty()) {
                    System.out.println("Nenhum cliente conectado após 2 minutos.");
                    System.exit(0);
                } else {
                    if (!temVencedor) {
                        // Sorteia um número de 1 a 75 e envia como mensagem
                        System.out.println("Iniciando o sorteio");

                        // int randomNumber = getRandomNumber(1, 75);
                        int randomNumber = sortearNumero();
                        sendRandomNumberMessage(randomNumber);
                    } else {
                        System.out.println("Sorteio interrompido. Já temos um vencedor.");
                        timer.cancel();
                    }
                }
            }
        }, 120000, 15000); // 2 minutos em milissegundos, 15 segundos entre execuções
    }

    private void sendRandomNumberMessage(int randomNumber) {
        // Constrói a mensagem com o número sorteado
        String msg = Integer.toString(randomNumber);
        // Envia a mensagem a todos os clientes
        broadcasting();
        sendMsgToAll(null, msg);
    }

    private int getRandomNumber(int min, int max) {
        // Gera um número aleatório entre min (inclusive) e max (exclusive)
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public int sortearNumero() {
        numerosSorteados = new LinkedHashSet<>();
        int numeroSorteado = new Random().nextInt(75) + 1;

        while (!validarNumeroJaFoiSorteado(numeroSorteado)) {
            numeroSorteado = new Random().nextInt(75) + 1;
        }

        return numeroSorteado;
    }

    public boolean validarNumeroJaFoiSorteado(int numeroSorteado) {
        return numerosSorteados.add(numeroSorteado);
    }

    private void sendMsgToAll(ClientSocket sender, String msg) {
        if (clientes != null) {
            for (ClientSocket clientSocket : clientes) {
                clientSocket.sendMsg(msg);
                System.out.println("mensagem " + msg + " enviada ao cliente " + clientSocket.getRemoteSocketAddress());
            }
        } else {
            System.out.println("Lista de clientes vazia. O sistema será encerrado.");
            System.exit(0);
        }
    }
    
    private void broadcasting() {
        if (clientes != null) {
            for (ClientSocket clientSocket : clientes) {
                System.out.println("Enviando messagem de broadcasting ao cliente " + clientSocket.getRemoteSocketAddress());
                System.out.println(clientSocket.sendMsg("broadcast"));
                if (!clientSocket.sendMsg("broadcast")) {
                    System.out.println("Cliente: " + clientSocket.getRemoteSocketAddress() + " se desconectou e será removido da listagem.");
                    clientes.remove(clientSocket);
                }
            }
        } else {
            System.out.println("Lista de clientes vazia. O sistema será encerrado.");
            System.exit(0);
        }
    }

    private void restartTimerCycle() {
        // Reinicia as variáveis e chama o método startTimer()
        temVencedor = false;
        numerosSorteados.clear();
        timer.cancel();
        startTimer();
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        try {
            server.start();
            System.out.println("");
        } catch (IOException ex) {
            System.out.println("Erro ao iniciar o servidor: " + ex.getMessage());
        } 
    }

}
