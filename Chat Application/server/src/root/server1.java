package root;

import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class server1 {
    Socket ss;
    server1(int port){
        try{
            ServerSocket server = new ServerSocket(port);
            //server.bind(new InetSocketAddress("192.168.43.135", port));
            System.out.println("server started, connecting to client");
            ss = server.accept();
            System.out.println("connected to client");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    String receiveMessage(){
        String msg = null;
        try {
            Scanner s = new Scanner(ss.getInputStream());
            msg = s.nextLine();
        }catch(Exception e){
            return null;
        }
        return msg;
    }

    void sendMessage(String msg, boolean flood){
        try {
            PrintWriter output = new PrintWriter(ss.getOutputStream(), flood);
            output.println(msg);
        }catch(Exception e){}
    }
}
