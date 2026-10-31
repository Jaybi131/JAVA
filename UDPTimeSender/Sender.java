package Aufgaben;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.time.LocalTime;

public class Sender {

    private final String host;
    private final int port;

    public Sender(String host, int port) {
        this.host = host;
        this.port = port;
    }

    private void sendMessage() {
        LocalTime time = LocalTime.now();

        // Три байта: часы, минуты и секунды.
        byte[] data = {
            (byte) time.getHour(),
            (byte) time.getMinute(),
            (byte) time.getSecond()
        };

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(host);

            DatagramPacket packet = new DatagramPacket(
                data,
                data.length,
                address,
                port
            );

            socket.send(packet);

            /*System.out.printf(
                "Отправлено: %02d:%02d:%02d%n",
                time.getHour(),
                time.getMinute(),
                time.getSecond()
            );*/

        } catch (IOException e) {
            System.err.println("Ошибка отправки: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length != 2) {
            System.err.println(
                "Запуск: java Aufgaben.Sender <host> <port>"
            );
            return;
        }

        int port;

        try {
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Порт должен быть целым числом.");
            return;
        }

        if (port < 1 || port > 65535) {
            System.err.println("Порт должен быть от 1 до 65535.");
            return;
        }

        Sender sender = new Sender(args[0], port);

        while (true) {
            sender.sendMessage();
            Thread.sleep(1000);
        }
    }
}