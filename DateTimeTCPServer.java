import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateTimeTCPServer {
    public final static String SERVER_IP = "127.0.0.1";
    public final static int SERVER_PORT = 7890;
	
	public static void main(String[] args) {
		try {
            
			ServerSocket ss = new ServerSocket(SERVER_PORT);
			System.out.println("Server has been created Waiting fot Client: "
					+ ss.getInetAddress().getHostAddress() + "/" + ss.getLocalPort() + "...");
			
			Socket s = ss.accept();
			System.out.println("Conected " + s.getRemoteSocketAddress());
			
			String remoteIP = s.getInetAddress().getHostAddress();
			String remotePort = ":"+s.getLocalPort();
			System.out.println("remoteIP: "+remoteIP+" / remotePort: "+remotePort);
			
			PrintStream welcome = new PrintStream(s.getOutputStream());
			welcome.println("");
			
			String msg_in="";
            
            DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
            DateFormat fortime = new SimpleDateFormat("hh/mm/ss");
			if(!msg_in.equals("DATE")) 
			{   
            
				PrintStream outToClient = new PrintStream(s.getOutputStream());
				outToClient.println(fordate);
                
            }
            if (!msg_in.equals("TIME")){

                PrintStream outToClient = new PrintStream(s.getOutputStream());
				outToClient.println(fortime);

            }  
                ss.close();

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}