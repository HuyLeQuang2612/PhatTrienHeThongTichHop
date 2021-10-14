import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ClientHandler extends Thread {
    DateFormat fordate = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat fortime = new SimpleDateFormat("hh/mm/ss");

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    public ClientHandler (Socket s, DataInputStream dis , DataOutputStream dos){
        this.dis = dis;
        this.dos = dos;
        this.s = s ;
    }
    public void run(){
        String recive ;
        String toreturn;
        while(true){
            try{
                dos.writeUTF("Select option [DATE|TIME]..");
    
                recive =dis.readUTF();
    
                if(recive.equals("Exit")){
                System.out.println("Client" + this.s);
                System.out.println("dang ket noi");
                this.s.close();
                System.out.println("Da dong ket noi");
                break;
                }
                Date date = new Date();
    
                switch(recive){
                    case "DATE" :
                        toreturn = fordate.format(date);
                        dos.writeUTF(toreturn);
                        break;
                    case "TIME" :
                        toreturn = fordate.format(date);
                        dos.writeUTF(toreturn);
                        break;
                }
            }
            catch (Exception e) {
                e.getStackTrace();
            }
            /*finally {
                if (s != null){
                    try {
                        s.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }*/
    }  
}   
}



