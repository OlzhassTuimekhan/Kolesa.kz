import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("10.48.147.23", 8888)) { // Подключение к серверу
            System.out.println("Connected to the server.");
            new Thread(new ReadTask(socket)).start(); // Поток для чтения сообщений от сервера

            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String message;
            while ((message = consoleReader.readLine()) != null) {
                writer.println(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ReadTask implements Runnable {
    private final Socket socket;

    public ReadTask(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Server: " + message); // Печатаем сообщение от сервера
            }
        } catch (IOException e) {
            System.out.println("Disconnected from the server.");
        }
    }
}

