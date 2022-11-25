package labs.ip.tema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class ServerThread extends Thread{
    protected static ArrayList<PersoanaFacultate> persoaneFacultate = new ArrayList<>();
    protected Socket client;

    public static ArrayList<PersoanaFacultate> getPersoaneFacultate() {
        return persoaneFacultate;
    }

    public ServerThread(Socket client) {
        this.client = client;
    }

    public synchronized void addHumans(PersoanaFacultate h){
        persoaneFacultate.add(h);
    }

    @Override
    public void run() {
        try {
            PrintWriter out =
                    new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            BufferedReader stdIn = new BufferedReader(
                    new InputStreamReader(System.in));
            out.println("Server: Conexiune realizata");

            String inputLine,outputLine;
            while (true) {
                if(in.ready()){
                    inputLine = in.readLine();
                    //System.out.println("Mesajul de la client:   " + inputLine);
                    String delim = " ";
                    String[] dataHuman = inputLine.split(delim);
                    if(dataHuman[0].equals("Student")){
                        Student std = new Student(dataHuman[1], dataHuman[2],
                                dataHuman[3], Short.valueOf(dataHuman[4]),
                                Short.valueOf(dataHuman[5]));
                        addHumans(std);
                    }
                    if(dataHuman[0].equals("Profesor")){
                        Profesor prof = new Profesor(dataHuman[1],
                                dataHuman[2], dataHuman[3],
                                Short.valueOf(dataHuman[4]), dataHuman[5]);
                        addHumans(prof);
                    }
                    if(dataHuman[0].equals("Student") || dataHuman[0].equals("Profesor")){
                        Collections.sort(getPersoaneFacultate());
                        System.out.println(getPersoaneFacultate());
                    }
                }
                if(stdIn.ready()){
                    outputLine = stdIn.readLine();
                    out.println(outputLine);
                    if (outputLine.equals("Bye."))
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
