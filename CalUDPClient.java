import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class CalUDPClient {
    public static void main(String args[])
        throws IOException
    {
  
        // tạo phần đọc dữ liệu vào 
        Scanner sc = new Scanner(System.in);
  
        // Step 1
        // tạo socket mang dữ liệu 
        DatagramSocket ds = new DatagramSocket();
  
        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;
  
        // tạo vòng lặp tránh say bye là "bye"
        while (true) {
  
            System.out.print("Please enter the math:");
            // Chờ nhập đầu vào
            String inp = sc.nextLine();
            buf = new byte[65535];
  
            // Chuyển chuỗi thành mảng byte 
            buf = inp.getBytes();
  
            // Step 2
            // tạo datagrampacket gửi dữ liệu
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234);
            ds.send(DpSend);
  
            // phá vòng lặp
            if (inp.equals("bye"))
                break;
  
            buf = new byte[65535];
  
            // tạo datagrampacket nhằm nhận dữ liệu
            DatagramPacket DpReceive = new DatagramPacket(buf, buf.length);
            ds.receive(DpReceive);
  
            // xuất
            System.out.println("Answer = " + new String(buf, 0, buf.length));
        }
    }
}