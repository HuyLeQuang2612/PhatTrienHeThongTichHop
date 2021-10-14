import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class DateTimeTCPClient {
    
	public final static String SERVER_IP = "127.0.0.1";
    public final static int SERVER_PORT = 7890;
	
	public static void main(String[] args) {
		try {
			DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
            DateFormat fortime = new SimpleDateFormat("hh/mm/ss");
			
            Socket s = new Socket(SERVER_IP, SERVER_PORT);
			System.out.println("");
			
			Scanner welcome = new Scanner(s.getInputStream());
			System.out.println("Server: " + welcome.nextLine());
			
            String msg_out = "";
			if(!msg_out.equals("DATE")) {
				
				PrintStream outToServer = new PrintStream(s.getOutputStream());	
				outToServer.println(fordate);
					
			}
            if(!msg_out.equals("TIME")){
                PrintStream outToServer = new PrintStream(s.getOutputStream());	
				outToServer.println(fortime);
            }
			s.close();

			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
