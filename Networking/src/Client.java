import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        DataOutputStream toServer;
        DataInputStream fromServer;

        try {
            Socket socket = new Socket("localhost", 8000);
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());

            toServer.writeDouble(3);
            double area = fromServer.readDouble();

            System.out.println("Radius is 3");
            System.out.println("Area is: " + area);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
