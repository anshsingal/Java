package root;

public class listen extends Thread{
    server1 s1;
    public listen(int port){
        s1 = new server1(port);
    }
    public void run(){
        String msg;
        while(true){
            msg = s1.receiveMessage();
            if(msg==null) {
                break;
            }
                System.out.println("client@ "+java.time.LocalTime.now().getHour()+":"+java.time.LocalTime.now().getMinute()+" : "+msg);
        }
        System.out.println("client died");
    }
}
