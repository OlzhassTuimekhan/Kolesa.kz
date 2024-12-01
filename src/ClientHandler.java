import java.io.*;
import java.net.Socket;

class ClientHandler implements Runnable, Observer {
    private final Socket socket;
    private final ChatServer server;
    private PrintWriter out;

    public ClientHandler(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run() {
        try (
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        ) {
            out = new PrintWriter(socket.getOutputStream(), true);
            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                server.notifyObservers(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.removeObserver(this);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(String message) {
        if (out != null) {
            out.println(message);
        }
    }
}
