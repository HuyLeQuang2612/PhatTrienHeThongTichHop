import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.net.*;
import java.io.*;


public class DateTimeUDPClient {
    public static void main(String[] args) {
        try {
            final int PORT = 1500 ;
            DatagramSocket ds = new DatagramSocket();
            InetAddress serveAddress = InetAddress .getByName("127.0.0.9");
            Scanner scn = new Scanner(System.in);
            System.out.println("UDP server da dc tao");
            while (true) {
                // gui
                System.out.println("Choose your selection: ");
                String str = scn.nextLine();
                byte[] output = str.getBytes();

                //lưu ý 4 thông số của DatagramPacket : mảng byte , length , address , port
                //odp là outputDataPacket
                DatagramPacket odp = new DatagramPacket(output, output.length, serveAddress , PORT);
                ds.send(odp);

                // nhận dữ liệu từ server
                // tạo sao cho chứa được tầm ... mà tối đa là 60000 byte 
                byte[] input = new byte[60000];

                // 2 đối số : mảng byte , length
                //idp là inputDataPacket 
                DatagramPacket idp = new DatagramPacket(input, input.length);
                ds.receive(idp);

                // getData là return to data buffer 
                //chuyển đổi byte thành string từ 0 tới hết chuỗi idp 
                String inputStr = new String(idp.getData(),0,idp.getLength());
                System.out.println(":" + inputStr);

            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("EROR !!!" + e.toString());
        }
    }
}