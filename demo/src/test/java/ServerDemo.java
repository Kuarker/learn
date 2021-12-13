import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @description:
 * @author: Jiayan Lee
 * @date: 2021-11-20
 **/
public class ServerDemo {
    public static void main(String[] args) throws Exception {

        DatagramSocket socket = new DatagramSocket(9999);
        while (true) {
            System.out.println("接受开始--》》》》");
            byte[] buff = new byte[1024 * 64];
            String temp1 = new String(buff);
            System.out.println(temp1);
            DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length);
            socket.receive(datagramPacket);
            System.out.println(datagramPacket.getAddress());
            String temp2 = new String(buff, 0, datagramPacket.getLength());
            System.out.println(temp2);

            System.out.println("接受结束--》》》》\n");
        }
    }
}
