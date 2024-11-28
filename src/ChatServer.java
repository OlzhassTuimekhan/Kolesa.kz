import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer implements Subject {
    private final List<Observer> observers = new ArrayList<>(); // Список наблюдателей

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        new Thread(server::startServer).start(); // Запускаем сервер в отдельном потоке
        new Admin(server).start(); // Запускаем администратора
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(8888)) { // Порт 12345
            System.out.println("Server started. Waiting for clients...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected.");
                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                addObserver(clientHandler); // Добавляем клиента как наблюдателя
                new Thread(clientHandler).start(); // Запускаем поток для обработки клиента
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Реализация методов Subject
    @Override
    public synchronized void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public synchronized void removeObserver(Observer observer) {
        observers.remove(observer);
        System.out.println("Observer removed.");
    }

    @Override
    public synchronized void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    // Отправка сообщения от администратора
    public void broadcastMessageFromAdmin(String message) {
        System.out.println("Admin: " + message); // Логируем сообщение от администратора
        notifyObservers("[ADMIN]: " + message); // Уведомляем всех наблюдателей
    }
}
