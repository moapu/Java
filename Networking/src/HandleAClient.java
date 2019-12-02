import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HandleAClient implements Runnable {

    private Socket socket;

    HandleAClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            double radius = inputFromClient.readDouble();
            double area = radius * radius * Math.PI;
            outputToClient.writeDouble(area);

            System.out.println("Radius received from client: " + radius);
            System.out.println("Area is: " + area);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
