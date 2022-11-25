package labs.ip.tema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String hostName = "localhost";
        int portNumber = 1025;
        try {
            Socket me = new Socket(hostName, portNumber);
            PrintWriter out = new PrintWriter(me.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(me.getInputStream()));
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
            String fromServer, fromUser;
            while (true) {
                if(in.ready()){
                    fromServer = in.readLine();
                    System.out.println("Server: " + fromServer);
                    if (fromServer.equals("Bye."))
                        break;
                }

                if(stdIn.ready()) {
                    fromUser = stdIn.readLine();
                    if (fromUser != null) {
                        out.println(fromUser);
                    }
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
