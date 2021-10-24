import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class UDPFileServer {
    private static final int PORT = 9000;
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            byte[] inputByte = new byte[60000];
            
            System.out.println("Create Server : Done... ");

            while (true) {
                // Nhận tên file từ client
                DatagramPacket inputPack = new DatagramPacket(inputByte, inputByte.length);
                socket.receive(inputPack);
                String inputStr = new String(inputPack.getData(), 0, inputPack.getLength());
                String fileName = inputStr.substring(5);

                // Đọc file
                File file = new File(fileName);
                int fileLength = (int)file.length();
                byte[] outputByte = new byte[fileLength];
                FileInputStream fis = new FileInputStream(file);
                fis.read(outputByte);

                //xử lý hiển thị cả file 
                DatagramPacket inputPackStr = new DatagramPacket(outputByte, outputByte.length);
                String inputStrFile = new String(inputPackStr.getData(),0, inputPackStr.getLength());
                System.out.println("File text:" + inputStrFile + "\n");
                
                // Xử lý đảo ngược
                Scanner sc = new Scanner(file);
                String fileReverse = "";
                String reverse;
                while (sc.hasNextLine()) {
                    reverse = new StringBuffer(sc.nextLine()).reverse().toString();
                    fileReverse = fileReverse.concat((reverse + "\n"));
                }
                System.out.println("Reverse file:" + fileReverse);
                
                //xử lý chữ in hoa
                String fileUpercase = "";
                String upercase;
                while (sc.hasNextLine()){
                    upercase = new String(sc.nextLine()).toUpperCase().toString();
                    fileUpercase = fileUpercase.concat((upercase + "\n"));
                }
                System.out.println("Upercase file:" + fileUpercase);

                // Gửi dữ liệu cho client
                outputByte = fileReverse.getBytes();
                DatagramPacket outputPack = new DatagramPacket(outputByte, outputByte.length, inputPack.getAddress(), inputPack.getPort());
                socket.send(outputPack);
            }

        } catch (IOException ex) {
            System.out.println("Loi Server: " + ex.toString());
        }
    }
}
