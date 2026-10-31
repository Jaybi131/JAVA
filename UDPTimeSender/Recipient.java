package Aufgaben;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Recipient {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println(
                "Запуск: java Aufgaben.Recipient <port> <dec|hex>"
            );
            return;
        }

        int port;

        try {
            port = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Порт должен быть целым числом.");
            return;
        }

        if (port < 1 || port > 65535) {
            System.err.println("Порт должен быть от 1 до 65535.");
            return;
        }

        String mode = args[1];

        if (!mode.equalsIgnoreCase("dec")
                && !mode.equalsIgnoreCase("hex")) {
            System.err.println("Формат должен быть dec или hex.");
            return;
        }

        try (DatagramSocket socket = new DatagramSocket(port)) {
            byte[] buffer = new byte[5];

            while (true) {
                DatagramPacket packet = new DatagramPacket(
                    buffer,
                    buffer.length
                );

                socket.receive(packet);

                if (packet.getLength() != 3) {
                    System.err.println(
                        "Ожидалось три байта с временем."
                    );
                    continue;
                }

                byte[] data = packet.getData();

                int hours = Byte.toUnsignedInt(data[0]);
                int minutes = Byte.toUnsignedInt(data[1]);
                int seconds = Byte.toUnsignedInt(data[2]);

                if (mode.equalsIgnoreCase("hex")) {
                    System.out.printf(
                        "\r%02X:%02X:%02X",
                        hours, minutes, seconds
                    );
                } else {
                    System.out.printf(
                        "\r%02d:%02d:%02d",
                        hours, minutes, seconds
                    );
                }

                System.out.flush();
            }

        } catch (IOException e) {
            System.err.println("Ошибка приёма: " + e.getMessage());
        }
    }
}