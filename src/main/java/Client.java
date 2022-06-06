import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        String[] msgs = {"Привет", "Иван Васильевич", "25", "ymaha@tru.pru", "*******", "*******"};
        String host = "netology.homework";
        int port = 8800;
        try(Socket socket = new Socket(host, port);
            BufferedReader in =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);) {

            int i = 0;
            String line;

            while(true) {
                if (in.ready()) {
                    line = in.readLine();
                    if(line.equals("Ok")){
                        System.out.println(line);
                        out.println("by");
                        socket.close();
                        break;
                    }
                        System.out.println(line);
                        out.println(msgs[i]);
                        i++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
