package root;

public class listen extends Thread{
    client1 s1;
    public listen(String ip, int port){
        s1 = new client1(ip, port);
    }
    public void run(){
        String msg;
        while(true){
            msg = s1.receiveMessage();
            if(msg==null) {
                break;
            }
            System.out.println("server@ "+java.time.LocalTime.now().getHour()+":"+java.time.LocalTime.now().getMinute()+" : "+msg);        }
        System.out.println("client died");
    }
}
