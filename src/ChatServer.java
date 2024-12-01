import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private static ChatServer instance;

    private ChatServer() {}


    public static synchronized ChatServer getInstance() {
        if (instance == null) {
            instance = new ChatServer();
        }
        return instance;
    }

    public void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            System.out.println("Server started. Waiting for clients...");
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("\nServer: New client connected.");
                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                addObserver(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


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

    public void broadcastMessageFromAdmin(String message) {
        notifyObservers("[ADMIN]: " + message);
    }
}
