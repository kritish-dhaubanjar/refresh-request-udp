import java.io.IOException;
import java.net.*;

public class Sender extends Thread {

    private String message = "REFRESH";
    private int port = 8085;
    private String host = "224.0.0.1";

    public Sender (){}

    @Override
    public void run() {

        try{

            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName(host);
            byte [] buffer = message.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, address, port);
            socket.send(datagramPacket);
            socket.close();

        }catch (SocketException | UnknownHostException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
