package org.example;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        int i = 0;
        List<String> cities = List.of("London", "Paris", "Berlin", "Tokyo", "Moscow");
        List<String> temp = List.of("11.2", "22.5", "4.2", "4.9", "33");
        Random random = new Random();
        while (i != 100) {
            try (Socket socket = new Socket()) {
                socket.connect(new InetSocketAddress("localhost", 8080), 3000);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                String city = cities.stream()
                        .skip(random.nextInt(cities.size())) // пропускаем случайное количество элементов
                        .findFirst()
                        .orElse("Minsk");
                String temperature = temp.stream()
                        .skip(random.nextInt(temp.size()))
                        .findFirst().orElse("0");
                String message = city.concat(":" + temperature);
                out.println(message);
                String response = in.readLine();
                if (response != null) {
                    System.out.println("Hub says: " + response);
                } else {
                    System.out.println("Hub closed the connection without an ACK.");
                }
                i++;
                in.close();
                out.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
