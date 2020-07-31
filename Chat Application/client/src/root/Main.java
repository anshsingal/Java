package root;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String ip = "localhost";
        int port = 5000;

        Scanner s1 = new Scanner(System.in);
	    listen c1 = new listen(ip, port);
	    client1 t1 = c1.s1;
	    c1.start();
	    while(true){
            t1.sendMessage(s1.nextLine(), true);
        }
    }
}
