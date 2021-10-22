import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;
  
class CalUDPServer {
    public static void main(String[] args) throws IOException
    {
        // tạo socket ở port 1234
        DatagramSocket ds = new DatagramSocket(1234);
  
        byte[] buf = null;
  
        // Khởi tạo ban đầu là null 
        DatagramPacket DpReceive = null;
        DatagramPacket DpSend = null;
  
        while (true) {
            buf = new byte[65535];
  
            // tạo datagrampacket nhận thông tin với cái tên DpReceive
            DpReceive = new DatagramPacket(buf, buf.length);
  
            // nhận dữ liệu thông qua buffer 
            ds.receive(DpReceive);
  
            String inp = new String(buf, 0, buf.length);
  
            // xài trim() để loại bỏ khoảng trắng
            inp = inp.trim();
  
            System.out.println("Equation Received:- " + inp);
  
            // thoát server nếu client say bye là "bye"
            if (inp.equals("bye")) {
                System.out.println(
                    "Client sent bye.....EXITING");
                break;
            }
            int result;
            // Sử dụng StringTokenizer để chia phương trình thành toán hạng và hoạt động 
            StringTokenizer st = new StringTokenizer(inp);
  
            int oprnd1 = Integer.parseInt(st.nextToken());
            String operation = st.nextToken();
            int oprnd2 = Integer.parseInt(st.nextToken());
  
            // Điều kiện để hoạt động
            if (operation.equals("+"))
                result = oprnd1 + oprnd2;
  
            else if (operation.equals("-"))
                result = oprnd1 - oprnd2;
  
            else if (operation.equals("*"))
                result = oprnd1 * oprnd2;
  
            else
                result = oprnd1 / oprnd2;
  
            System.out.println("Sending the result...");
            String res = Integer.toString(result);
  
            // chuyển đổi buffer thành byte
            buf = res.getBytes();
  
            // Lấy port của Client 
            int port = DpReceive.getPort();
            //gửi dữ liệu tới Client 
            DpSend = new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(),port);
            ds.send(DpSend);
        }
    }
}