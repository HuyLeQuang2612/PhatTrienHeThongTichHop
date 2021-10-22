
import java.net.DatagramSocket;
import java.util.Date;
import java.net.DatagramPacket;
import java.net.*;
import java.io.*;

public class DateTimeUDPServer {
    public static void main(String[] args) {
        try {
            final int PORT = 1500 ;
            DatagramSocket ds = new DatagramSocket();
            while (true) {
                // nhận dữ liệu từ client
                byte[] input = new byte[1];
                DatagramPacket idp = new DatagramPacket(input ,0);
                ds.receive(idp);
                
                //xữ lý
                Date date  = new Date();
                String outputStr = date.toString();
                
                //gửi dữ liệu từ client
                byte[] output = outputStr.getBytes();
                DatagramPacket odp = new DatagramPacket(output, outputStr.length(),idp.getAddress(),idp.getPort());
                ds.send(odp);
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}