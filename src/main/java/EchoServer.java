import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {


        String[] msgs = {"Назовитесь пожалуйста", "Укажите свой возраст", "Укажите email", "Укажите пароль", "Повторите пароль", "Ok"};
        int port = 8800;

        try (ServerSocket serverSocket = new ServerSocket(port);){
            Socket socket = serverSocket.accept();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            if(socket.isConnected()) {
                System.out.println("Клиент подключился");
                out.println("Добро пожаловать!");
            }

            String line;
            int i = 0;

            while(true) {
                if(in.ready()) {
                    line = in.readLine();
                    if (line.equals("by")) {
                        System.out.println(line);
                        out.println("hahaha!!  " + line);
                        break;
                    }
                    System.out.println(line);
                    out.println(msgs[i]);
                    i++;
                }
            }
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
