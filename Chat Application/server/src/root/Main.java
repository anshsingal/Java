package root;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int port = 5000;
        Scanner s1 = new Scanner(System.in);
        listen l1 = new listen(port);
        server1 t1 = l1.s1;
        l1.start();

        while(true){
            t1.sendMessage(s1.nextLine(), true);
        }
    }
}

