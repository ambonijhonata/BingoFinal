package Control;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 
@author Pichau*/
public class ClientSocket {

    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;
    private String login;

    public ClientSocket(Socket socket) throws IOException {
        this.socket = socket;
        System.out.println("Cliente " + this.socket.getLocalSocketAddress() + " conectado.");
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));;
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public String getMessage() {
        try {
//            System.out.println("getMessage() " + in.readLine());
            return in.readLine();
        } catch (IOException ex) {
            return null;
        }
    }


    public boolean sendMsg(String msg) {
        out.println(msg);
        return !out.checkError();
    }

//    public boolean sendMsg(Pacote msg) {
//        out.println(msg);
//        return !out.checkError();
//    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }
    
    public SocketAddress getLocalSocketAddres(){
        return socket.getLocalSocketAddress();
    }

    public void close() {
        try {
            in.close();
            out.close();;
            socket.close();
        } catch (IOException ex) {
            System.out.println("Erro ao fechar o socket");
        }
    }
}