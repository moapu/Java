package sending_objects;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class StudentServer {

    public static void main(String[] args) {
        ObjectOutputStream outputToFile = null;
        ObjectInputStream inputFromClient = null;

        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started ");
            outputToFile = new ObjectOutputStream(new FileOutputStream("student.dat", true));

            while (true) {
                Socket socket = serverSocket.accept();
                inputFromClient = new ObjectInputStream(socket.getInputStream());
                Object object = inputFromClient.readObject();
                outputToFile.writeObject(object);
                System.out.println("A new student object is stored");
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                inputFromClient.close();
                outputToFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
