package root;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class client1 {
    Socket client;
    client1(String ip, int port){
        try {
            client = new Socket(ip, port);
            System.out.println("connected to server");
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    void sendMessage(String msg, boolean flood)  {
        try {
            PrintWriter output = new PrintWriter(client.getOutputStream(), flood);
            output.println(msg);
        }catch(Exception e){}
    }

    String receiveMessage(){
        String msg = null;
        try {
            Scanner s = new Scanner(client.getInputStream());
            msg = s.nextLine();
        }catch(Exception e){}
        return msg;
    }
}
