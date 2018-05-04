import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receiver extends Thread {

    private int port = 8085;
    private String host = "224.0.0.1";

    @Override
    public void run() {

        try{
            byte [] buffer = new byte[10];
            MulticastSocket socket = new MulticastSocket(8085);
            InetAddress address = InetAddress.getByName(host);
            socket.joinGroup(address);
            while (true){
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                refresh();
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void refresh(){
        System.out.println("public void refresh()");
    }
}
