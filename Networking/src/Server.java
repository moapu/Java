import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started @ " + new Date());
            Socket socket = serverSocket.accept();
            InetAddress inetAddress = socket.getInetAddress();

            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            double radius = inputFromClient.readDouble();
            double area = radius * radius * Math.PI;
            outputToClient.writeDouble(area);

            System.out.println("Host Name: " + inetAddress.getHostName());
            System.out.println("Client's IP address: " + inetAddress.getHostAddress());
            System.out.println("Radius received from client: " + radius);
            System.out.println("Area is: " + area);


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
