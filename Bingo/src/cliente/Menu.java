package cliente;

import Control.ClientSocket;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Menu extends javax.swing.JFrame implements Runnable {

    int placarMax = 6;
    int placar = 0;
    int numSorteado = 2;
    private ClientSocket socket;

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private PrintWriter out;
    private boolean temGanhardor = false;
    public static final int PORT = 4000;
    private String localAddres;

    Timer timer = new Timer();

    ArrayList<Integer> numCartela = new ArrayList<>();

    ArrayList<Integer> numSortear = new ArrayList<>();

    @Override
    public void run() {
        while (!Thread.currentThread().interrupted()) {

            String msg;
            while ((msg = socket.getMessage()) != null) {
                if (msg.contains("Vencedor")) {
                    placar = 0;
                    setCasas();
                    System.out.println("Tem vencedor");
                    txtTitulo.setText(msg);
                    txtErro.setText("Aguardando nova partida");
                    continue;
                } else if (!msg.contains("Vencedor")) {                    
                    txtTitulo.setText("Casa Número: " + msg);
                    txtErro.setText("   ");

                    try {
                        numSorteado = Integer.valueOf(msg);

                        System.out.printf("\nMsg recebida: %s\n", msg);

                        if (btnCasa01.getText().equals(msg)) {
                            btnCasa01.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa02.getText().equals(msg)) {
                            btnCasa02.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa03.getText().equals(msg)) {
                            btnCasa03.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa04.getText().equals(msg)) {
                            btnCasa04.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa05.getText().equals(msg)) {
                            btnCasa05.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa06.getText().equals(msg)) {
                            btnCasa06.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa07.getText().equals(msg)) {
                            btnCasa07.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa08.getText().equals(msg)) {
                            btnCasa08.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa09.getText().equals(msg)) {
                            btnCasa09.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa10.getText().equals(msg)) {
                            btnCasa10.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa11.getText().equals(msg)) {
                            btnCasa11.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa12.getText().equals(msg)) {
                            btnCasa12.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa13.getText().equals(msg)) {
                            btnCasa13.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa14.getText().equals(msg)) {
                            btnCasa14.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa15.getText().equals(msg)) {
                            btnCasa15.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa16.getText().equals(msg)) {
                            btnCasa16.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa17.getText().equals(msg)) {
                            btnCasa17.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa18.getText().equals(msg)) {
                            btnCasa18.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa19.getText().equals(msg)) {
                            btnCasa19.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa20.getText().equals(msg)) {
                            btnCasa20.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa21.getText().equals(msg)) {
                            btnCasa21.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa22.getText().equals(msg)) {
                            btnCasa22.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa23.getText().equals(msg)) {
                            btnCasa23.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa24.getText().equals(msg)) {
                            btnCasa24.setEnabled(false);
                            placar++;
                        }

                        if (btnCasa25.getText().equals(msg)) {
                            btnCasa25.setEnabled(false);
                            placar++;
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Mensagem de broadcasting recebida.");
                    }
                    if (placar == placarMax) {
                        socket.sendMsg("ganhou");
                    }
                }

            }

            System.out.println("mensagem final do servidor: " + msg);

//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
//                }
        }
    }

    public void setCasas() {
        ArrayList numASortear = new ArrayList<>();
        Random gerador = new Random();
        for (int i = 1; i <= 75; i++) {
            //System.out.println(i);
            numASortear.add(i);

        }
        int num = gerador.nextInt(numASortear.size() - 1) + 1;
        int casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa01.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa02.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa04.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa03.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa07.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa09.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa05.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa06.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa10.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa11.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa16.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa12.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa14.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa08.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa13.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa21.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa17.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa18.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa15.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa20.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa22.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa19.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa23.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa24.setText(Integer.toString(casa));
        num = gerador.nextInt(numASortear.size() - 1) + 1;
        casa = (Integer) numASortear.remove(num);
        numCartela.add(casa);
        btnCasa25.setText(Integer.toString(casa));

        btnCasa01.setEnabled(true);
        btnCasa02.setEnabled(true);
        btnCasa03.setEnabled(true);
        btnCasa04.setEnabled(true);
        btnCasa05.setEnabled(true);
        btnCasa06.setEnabled(true);
        btnCasa07.setEnabled(true);
        btnCasa08.setEnabled(true);
        btnCasa09.setEnabled(true);
        btnCasa10.setEnabled(true);
        btnCasa11.setEnabled(true);
        btnCasa12.setEnabled(true);
        btnCasa13.setEnabled(true);
        btnCasa14.setEnabled(true);
        btnCasa15.setEnabled(true);
        btnCasa16.setEnabled(true);
        btnCasa17.setEnabled(true);
        btnCasa18.setEnabled(true);
        btnCasa19.setEnabled(true);
        btnCasa20.setEnabled(true);
        btnCasa21.setEnabled(true);
        btnCasa22.setEnabled(true);
        btnCasa23.setEnabled(true);
        btnCasa24.setEnabled(true);
        btnCasa25.setEnabled(true);
    }

    public void start() throws IOException {
        try {
            socket = new ClientSocket(new Socket(SERVER_ADDRESS, PORT));
            System.out.println("Client conectado ao servidor: " + SERVER_ADDRESS + ":" + PORT);
            new Thread(this).start();
            System.out.println("saiu da thread");
//            messageLoop();

        } finally {

        }
    }

    public Menu() throws IOException {
        start();
        for (int count = 1; count <= 100; count++) {
            numSortear.add(count);
        }

        initComponents();

        setCasas();
        jTextFieldIPCliente.setText(socket.getLocalSocketAddres().toString());
        plnTab.setVisible(true);
        txtErro.setText("Número sorteado diferente do número da casa");
        plnIniciar.setVisible(false);
        txtErro.setText("    ");
        this.numSorteado = Integer.parseInt(btnCasa02.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plnTab = new javax.swing.JPanel();
        btnCasa01 = new javax.swing.JButton();
        btnCasa02 = new javax.swing.JButton();
        btnCasa04 = new javax.swing.JButton();
        btnCasa03 = new javax.swing.JButton();
        btnCasa07 = new javax.swing.JButton();
        btnCasa09 = new javax.swing.JButton();
        btnCasa05 = new javax.swing.JButton();
        btnCasa06 = new javax.swing.JButton();
        btnCasa10 = new javax.swing.JButton();
        btnCasa11 = new javax.swing.JButton();
        btnCasa16 = new javax.swing.JButton();
        btnCasa12 = new javax.swing.JButton();
        btnCasa14 = new javax.swing.JButton();
        btnCasa08 = new javax.swing.JButton();
        btnCasa13 = new javax.swing.JButton();
        btnCasa21 = new javax.swing.JButton();
        btnCasa17 = new javax.swing.JButton();
        btnCasa18 = new javax.swing.JButton();
        btnCasa15 = new javax.swing.JButton();
        btnCasa20 = new javax.swing.JButton();
        btnCasa22 = new javax.swing.JButton();
        btnCasa19 = new javax.swing.JButton();
        btnCasa23 = new javax.swing.JButton();
        btnCasa24 = new javax.swing.JButton();
        btnCasa25 = new javax.swing.JButton();
        txtTitulo = new javax.swing.JLabel();
        txtErro = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jTextFieldIPCliente = new javax.swing.JTextField();
        plnIniciar = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCasa01.setText("1");
        btnCasa01.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa01ActionPerformed(evt);
            }
        });

        btnCasa02.setText("2");
        btnCasa02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa02ActionPerformed(evt);
            }
        });

        btnCasa04.setText("4");
        btnCasa04.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa04ActionPerformed(evt);
            }
        });

        btnCasa03.setText("3");
        btnCasa03.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa03ActionPerformed(evt);
            }
        });

        btnCasa07.setText("jButton1");
        btnCasa07.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa07ActionPerformed(evt);
            }
        });

        btnCasa09.setText("jButton1");
        btnCasa09.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa09ActionPerformed(evt);
            }
        });

        btnCasa05.setText("5");
        btnCasa05.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa05ActionPerformed(evt);
            }
        });

        btnCasa06.setText("6");
        btnCasa06.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa06ActionPerformed(evt);
            }
        });

        btnCasa10.setText("jButton1");
        btnCasa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa10ActionPerformed(evt);
            }
        });

        btnCasa11.setText("jButton1");
        btnCasa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa11ActionPerformed(evt);
            }
        });

        btnCasa16.setText("jButton1");
        btnCasa16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa16ActionPerformed(evt);
            }
        });

        btnCasa12.setText("jButton1");
        btnCasa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa12ActionPerformed(evt);
            }
        });

        btnCasa14.setText("jButton1");
        btnCasa14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa14ActionPerformed(evt);
            }
        });

        btnCasa08.setText("jButton1");
        btnCasa08.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa08ActionPerformed(evt);
            }
        });

        btnCasa13.setText("jButton1");
        btnCasa13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa13ActionPerformed(evt);
            }
        });

        btnCasa21.setText("jButton1");
        btnCasa21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa21ActionPerformed(evt);
            }
        });

        btnCasa17.setText("jButton1");
        btnCasa17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa17ActionPerformed(evt);
            }
        });

        btnCasa18.setText("jButton1");
        btnCasa18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa18ActionPerformed(evt);
            }
        });

        btnCasa15.setText("jButton1");
        btnCasa15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa15ActionPerformed(evt);
            }
        });

        btnCasa20.setText("jButton1");
        btnCasa20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa20ActionPerformed(evt);
            }
        });

        btnCasa22.setText("jButton1");
        btnCasa22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa22ActionPerformed(evt);
            }
        });

        btnCasa19.setText("jButton1");
        btnCasa19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa19ActionPerformed(evt);
            }
        });

        btnCasa23.setText("jButton1");
        btnCasa23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa23ActionPerformed(evt);
            }
        });

        btnCasa24.setText("jButton1");
        btnCasa24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa24ActionPerformed(evt);
            }
        });

        btnCasa25.setText("jButton1");
        btnCasa25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCasa25ActionPerformed(evt);
            }
        });

        txtTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        txtTitulo.setText("Casa Número:  ");

        txtErro.setText("Número sorteado diferente do número da casa");

        jLabelCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelCliente.setText("Cliente:");

        jTextFieldIPCliente.setEditable(false);
        jTextFieldIPCliente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout plnTabLayout = new javax.swing.GroupLayout(plnTab);
        plnTab.setLayout(plnTabLayout);
        plnTabLayout.setHorizontalGroup(
            plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plnTabLayout.createSequentialGroup()
                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plnTabLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(txtTitulo))
                    .addGroup(plnTabLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(txtErro))
                    .addGroup(plnTabLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(plnTabLayout.createSequentialGroup()
                                .addComponent(jLabelCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldIPCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(plnTabLayout.createSequentialGroup()
                                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCasa21, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCasa06, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCasa01, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCasa11, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCasa16, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0)
                                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(plnTabLayout.createSequentialGroup()
                                        .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnCasa17, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnCasa07, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnCasa12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnCasa02, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(plnTabLayout.createSequentialGroup()
                                                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(plnTabLayout.createSequentialGroup()
                                                        .addComponent(btnCasa13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(btnCasa14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(plnTabLayout.createSequentialGroup()
                                                        .addComponent(btnCasa18, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(btnCasa19, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 0, 0)
                                                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnCasa20, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnCasa15, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(plnTabLayout.createSequentialGroup()
                                                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btnCasa08, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnCasa03, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, 0)
                                                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(plnTabLayout.createSequentialGroup()
                                                        .addComponent(btnCasa04, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(btnCasa05, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(plnTabLayout.createSequentialGroup()
                                                        .addComponent(btnCasa09, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(0, 0, 0)
                                                        .addComponent(btnCasa10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(plnTabLayout.createSequentialGroup()
                                        .addComponent(btnCasa22, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(btnCasa23, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(btnCasa24, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(btnCasa25, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(112, 112, 112))
        );
        plnTabLayout.setVerticalGroup(
            plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plnTabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtErro)
                .addGap(24, 24, 24)
                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCasa04, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa05, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa02, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa01, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa03, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCasa07, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa09, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa06, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa10, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa08, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCasa12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCasa13, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCasa14, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCasa15, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCasa11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCasa16, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa17, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa18, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa20, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa19, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCasa21, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa22, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa23, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa24, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCasa25, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plnTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCliente)
                    .addComponent(jTextFieldIPCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        plnIniciar.setPreferredSize(new java.awt.Dimension(722, 708));

        btnIniciar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnIniciar.setText("Iniciar Jogo");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        lblTitulo.setText("BINGOOO!!!!!!!!");

        javax.swing.GroupLayout plnIniciarLayout = new javax.swing.GroupLayout(plnIniciar);
        plnIniciar.setLayout(plnIniciarLayout);
        plnIniciarLayout.setHorizontalGroup(
            plnIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plnIniciarLayout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(plnIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plnIniciarLayout.createSequentialGroup()
                        .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        plnIniciarLayout.setVerticalGroup(
            plnIniciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plnIniciarLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(lblTitulo)
                .addGap(99, 99, 99)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(356, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plnTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(plnIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plnTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(plnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnCasa01ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa01ActionPerformed
        int casa = Integer.parseInt(btnCasa01.getText());

        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");
        } else {
            placar++;
            txtErro.setText("  ");
            btnCasa01.setEnabled(false);
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }


    }//GEN-LAST:event_btnCasa01ActionPerformed

    private void btnCasa02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa02ActionPerformed
        int casa = Integer.parseInt(btnCasa02.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");
        } else {
            placar++;
            txtErro.setText("  ");
            btnCasa02.setEnabled(false);
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }


    }//GEN-LAST:event_btnCasa02ActionPerformed

    private void btnCasa04ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa04ActionPerformed
        int casa = Integer.parseInt(btnCasa04.getText());

        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");
        } else {
            placar++;
            txtErro.setText("  ");
            btnCasa04.setEnabled(false);
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa04ActionPerformed

    private void btnCasa03ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa03ActionPerformed
        int casa = Integer.parseInt(btnCasa03.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa03.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa03ActionPerformed

    private void btnCasa07ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa07ActionPerformed
        int casa = Integer.parseInt(btnCasa07.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa07.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa07ActionPerformed

    private void btnCasa09ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa09ActionPerformed
        int casa = Integer.parseInt(btnCasa09.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa09.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa09ActionPerformed

    private void btnCasa05ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa05ActionPerformed
        int casa = Integer.parseInt(btnCasa05.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa05.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa05ActionPerformed

    private void btnCasa06ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa06ActionPerformed
        int casa = Integer.parseInt(btnCasa06.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {

            placar++;
            btnCasa06.setEnabled(false);
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa06ActionPerformed

    private void btnCasa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa10ActionPerformed
        int casa = Integer.parseInt(btnCasa10.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa10.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa10ActionPerformed

    private void btnCasa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa11ActionPerformed
        int casa = Integer.parseInt(btnCasa11.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa11.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa11ActionPerformed

    private void btnCasa16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa16ActionPerformed
        int casa = Integer.parseInt(btnCasa16.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa16.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa16ActionPerformed

    private void btnCasa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa12ActionPerformed
        int casa = Integer.parseInt(btnCasa12.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

            btnCasa12.setEnabled(false);
        } else {
            btnCasa12.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa12ActionPerformed

    private void btnCasa14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa14ActionPerformed
        int casa = Integer.parseInt(btnCasa14.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa14.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa14ActionPerformed

    private void btnCasa08ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa08ActionPerformed
        int casa = Integer.parseInt(btnCasa08.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa08.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa08ActionPerformed

    private void btnCasa13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa13ActionPerformed
        int casa = Integer.parseInt(btnCasa13.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {

            placar++;
            btnCasa13.setEnabled(false);
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa13ActionPerformed

    private void btnCasa21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa21ActionPerformed
        int casa = Integer.parseInt(btnCasa21.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa21.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa21ActionPerformed

    private void btnCasa17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa17ActionPerformed
        int casa = Integer.parseInt(btnCasa17.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa17.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa17ActionPerformed

    private void btnCasa18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa18ActionPerformed
        int casa = Integer.parseInt(btnCasa18.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa18.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa18ActionPerformed

    private void btnCasa15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa15ActionPerformed
        int casa = Integer.parseInt(btnCasa15.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");

        } else {
            btnCasa15.setEnabled(false);
            placar++;
            txtErro.setText("  ");
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa15ActionPerformed

    private void btnCasa20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa20ActionPerformed
        int casa = Integer.parseInt(btnCasa20.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");
        } else {
            placar++;
            txtErro.setText("  ");
            btnCasa20.setEnabled(false);
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa20ActionPerformed

    private void btnCasa22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa22ActionPerformed
        int casa = Integer.parseInt(btnCasa22.getText());

        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");
        } else {
            placar++;
            txtErro.setText("  ");
            btnCasa22.setEnabled(false);
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa22ActionPerformed

    private void btnCasa19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa19ActionPerformed
        int casa = Integer.parseInt(btnCasa19.getText());

        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");
        } else {
            placar++;
            txtErro.setText("  ");
            btnCasa19.setEnabled(false);
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa19ActionPerformed

    private void btnCasa23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa23ActionPerformed
        int casa = Integer.parseInt(btnCasa23.getText());

        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");
        } else {
            placar++;
            txtErro.setText("  ");
            btnCasa23.setEnabled(false);
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa23ActionPerformed

    private void btnCasa24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa24ActionPerformed
        int casa = Integer.parseInt(btnCasa24.getText());

        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");
        } else {
            placar++;
            txtErro.setText("  ");
            btnCasa24.setEnabled(false);
        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa24ActionPerformed

    private void btnCasa25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCasa25ActionPerformed
        int casa = Integer.parseInt(btnCasa25.getText());
        if (!(casa == numSorteado)) {
            txtErro.setText("Número sorteado diferente do número da casa");
            btnCasa25.setEnabled(false);

        } else {
            placar++;
            txtErro.setText("  ");

        }

        if (placar == placarMax) {
            socket.sendMsg("ganhou");
        }

    }//GEN-LAST:event_btnCasa25ActionPerformed

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        plnIniciar.setVisible(false);
        plnTab.setVisible(true);
    }//GEN-LAST:event_btnIniciarActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Menu().setVisible(true);
                } catch (IOException ex) {
                    System.out.println("Não foi possível conectar ao servidor.");
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCasa01;
    private javax.swing.JButton btnCasa02;
    private javax.swing.JButton btnCasa03;
    private javax.swing.JButton btnCasa04;
    private javax.swing.JButton btnCasa05;
    private javax.swing.JButton btnCasa06;
    private javax.swing.JButton btnCasa07;
    private javax.swing.JButton btnCasa08;
    private javax.swing.JButton btnCasa09;
    private javax.swing.JButton btnCasa10;
    private javax.swing.JButton btnCasa11;
    private javax.swing.JButton btnCasa12;
    private javax.swing.JButton btnCasa13;
    private javax.swing.JButton btnCasa14;
    private javax.swing.JButton btnCasa15;
    private javax.swing.JButton btnCasa16;
    private javax.swing.JButton btnCasa17;
    private javax.swing.JButton btnCasa18;
    private javax.swing.JButton btnCasa19;
    private javax.swing.JButton btnCasa20;
    private javax.swing.JButton btnCasa21;
    private javax.swing.JButton btnCasa22;
    private javax.swing.JButton btnCasa23;
    private javax.swing.JButton btnCasa24;
    private javax.swing.JButton btnCasa25;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JTextField jTextFieldIPCliente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel plnIniciar;
    private javax.swing.JPanel plnTab;
    private javax.swing.JLabel txtErro;
    private javax.swing.JLabel txtTitulo;
    // End of variables declaration//GEN-END:variables
}
