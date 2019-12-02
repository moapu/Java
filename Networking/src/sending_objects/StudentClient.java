package sending_objects;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class StudentClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);
            ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());

            StudentAddress s = new StudentAddress(
                    "name",
                    "1234",
                    "city",
                    "state",
                    "zip");
            toServer.writeObject(s);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
