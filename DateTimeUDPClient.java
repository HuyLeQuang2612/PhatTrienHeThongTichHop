import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.io.*;
import java.net.*;
public class DateTimeUDPClient {
    private static final int PORT= 1500;
    public static void main(String[] args) {
        try{
        DatagramSocket s = new DatagramSocket();
        InetAddress serveAddress = InetAddress.getByName("127.0.0.1");
        Scanner scn = new Scanner(System.in);
        while(true){
            //gửi dữ liệu qua sever
            System.out.println("Nhap yeu cau: ");
            String request = scn.nextLine();
            byte[] output = request.getBytes();
            // tao datagrampacket
            DatagramPacket odp = new DatagramPacket(output, output.length,
                 serveAddress, PORT);
            s.send(odp);
            //nhận dữ liệu từ server
            byte[] input = new byte[60000];
            DatagramPacket idp = new DatagramPacket(input, input.length);
            //Chuyển đổi chuỗi thàng string từ đầu cho tới hết chuỗi
            String inputStr =  new String(idp.getData(),0, idp.getLength());
            System.out.println("Ngày giờ hệ thống là: " + inputStr);
        }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
