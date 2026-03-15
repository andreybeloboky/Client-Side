package org.example;

import java.io.*;
import java.net.Socket;


public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 8080)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            out.println("Test:5.1");
            String data = in.readLine();
            System.out.println("Hub says: " + data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
