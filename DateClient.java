import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.Socket;
import java.util.Scanner;
import java.io.IOException;


public class DateClient {	
	public static void main(String[] args) throws EOFException, IOException{
        try{
        Socket s = new Socket("127.0.0.1", 4567);
        Scanner scn = new Scanner(System.in);
        DataInputStream dis =  new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		while(dis.available() > 0){
            System.out.println(dis.readUTF());
            String tosend = scn.nextLine();
            dos.writeUTF(tosend);

            if(tosend.equals("exit")){
                System.out.println("Dang dong ket noi: " + s);
                s.close();
                System.out.println("Da dong ket noi !!");
                break;
            }
            String recive = dis.readUTF();
            System.out.println(recive);

        }
			scn.close();
            dis.close();
            dos.close();
        
    }
        catch (Exception e) {
            e.printStackTrace();
        }
	}
}

