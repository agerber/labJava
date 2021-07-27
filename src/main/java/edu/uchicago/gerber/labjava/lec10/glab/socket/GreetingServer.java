package edu.uchicago.gerber.labjava.lec10.glab.socket;
// File Name GreetingServer.java

import java.net.*;
import java.io.*;


/*
A socket is an endpoint (combination server URL + port) for communication between two machines. The actual work of the socket is performed by an
instance of the SocketImpl class. An application, by changing the socket factory that creates the socket implementation,
can configure itself to create sockets appropriate to the local firewall.


 */
public class GreetingServer implements Runnable {
    private ServerSocket serverSocket;

    public GreetingServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);

    }
    public static void main(String[] args) {
        int port = 6061;
        try {
            Thread thr = new Thread(new GreetingServer(port));
            thr.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        Socket server = null;
        DataOutputStream out;
        try {
            server = serverSocket.accept();
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            System.out.println("Just connected to " + server.getRemoteSocketAddress());
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        outer:
        while (true) {
            try {
                String strDegree = "";
                String strConvertTo = "";
                String strResult = "";
                DataInputStream in = new DataInputStream(server.getInputStream());
                String strFromClient = in.readUTF();
                String[] strSplits = strFromClient.split(" ");
                if (strSplits.length != 3)
                    break outer;

                for (int nC = 0; nC < strSplits.length; nC++) {
                    if (strSplits[nC].equalsIgnoreCase("x")) {
                        break outer;
                    }
                    //ignore the "in"
                    switch (nC) {
                        case 0:
                            strDegree = strSplits[nC];
                            break;
                        case 2:
                            strConvertTo = strSplits[nC];
                            break;
                    }
                }
                if (strConvertTo.equalsIgnoreCase("C")) {
                      strResult = toCel(strDegree);
                } else {
                    strResult = toFar(strDegree);
                }
                System.out.println(strFromClient);
                out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("The server says that the answer is " + strResult);

            } catch (IOException e) {
                e.printStackTrace();
                break outer;
            }
        }

        try {
            out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("exit");
            System.out.println("Server shutting down.");
            server.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }


    private static String toCel(String strFar) {
        double dFar = Double.parseDouble(strFar);
        return String.valueOf((dFar - 32) * 5.0 / 9);
    }

    private static String toFar(String strCel) {
        double dCel = Double.parseDouble(strCel);
        return String.valueOf(dCel * 9 / 5.0 + 32);
    }



}