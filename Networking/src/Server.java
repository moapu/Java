import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

    public static void main(String[] args) {
        int clientNum = 0;

        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started @ " + new Date());

            while (true) {
                Socket socket = serverSocket.accept();
                InetAddress inetAddress = socket.getInetAddress();

                clientNum++;

                System.out.println("starting thread for client " + clientNum + " at " + new Date());
                System.out.println("Host name: " + inetAddress.getHostName());
                System.out.println("IP Add: " + inetAddress.getHostAddress());

                new Thread(new HandleAClient(socket)).start();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
