package org.example;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Socket socket = new Socket();
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            socket.connect(new InetSocketAddress("localhost", 8080), 3000);
            String message = scanner.nextLine();
            out.println(message);
            String response = in.readLine();
            if (response != null) {
                System.out.println("Hub says: " + response);
            } else {
                System.out.println("Hub closed the connection without an ACK.");
            }
        } catch (IOException e) {
            System.err.println("Connection error: " + e.getMessage());
        }
    }
}
