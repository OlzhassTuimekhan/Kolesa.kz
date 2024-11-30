import java.util.Scanner;

public class Admin {
    private final ChatServer server;

    public Admin(ChatServer server) {
        this.server = server;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Admin Console Started. Type messages to broadcast.");
        while (true) {
            System.out.print("Admin: ");
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("exit")) {
                System.out.println("Admin console closed.");
                System.exit(0);
                break;
            }
            server.broadcastMessageFromAdmin(message); // Отправляем сообщение всем клиентам
        }
        scanner.close();
    }
}
