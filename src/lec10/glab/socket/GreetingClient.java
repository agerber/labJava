package lec10.glab.socket;
// File Name GreetingClient.java

import java.net.*;
import java.io.*;
import java.util.Scanner;


//this is the client
public class GreetingClient {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 6061;
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);
            while (true) {
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);
                System.out.println("Please send your command to the server, such as '35 in C' or '76 in F' or x to quit");
                String strSendToServer = scan.nextLine();
                out.writeUTF(strSendToServer);
                InputStream inFromServer = client.getInputStream();
                DataInputStream in = new DataInputStream(inFromServer);
                String strReadFromServer = in.readUTF();
                if (strReadFromServer.equalsIgnoreCase("exit"))
                    break;
                else
                    System.out.println(strReadFromServer);
            }
            System.out.println("Client shutting down.");
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}