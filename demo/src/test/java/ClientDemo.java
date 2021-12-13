import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-11-20
 **/
public class ClientDemo {
    public static void main(String[] args) throws Exception {

        System.out.println("发送开始---》》》");
        DatagramSocket socket = new DatagramSocket();
        byte[] buf = "蛙哈哈哈哈k".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, 0, buf.length, InetAddress.getLocalHost(), 9999);
        socket.send(packet);
        socket.close();
        System.out.println("发送结束---》》》");
    }
}
