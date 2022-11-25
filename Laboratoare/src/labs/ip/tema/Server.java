package labs.ip.tema;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1025);
            server.setReuseAddress(true);
            while(true) {
                Socket client = server.accept();
                ServerThread clientThr = new ServerThread(client);
                clientThr.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println(ServerThread.getPersoaneFacultate());
    }
}
