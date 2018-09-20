import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

class RequestHandler implements Runnable {

    Socket socket;

    protected  RequestHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        
        try{

            byte[] buffer = new byte[1024*1024];

            DataInputStream inputStream = new DataInputStream(socket.getInputStream());

            inputStream.read(buffer);

            System.out.println(socket.getInetAddress().getHostAddress() +" Says "+ new String(buffer).trim());

            socket.shutdownInput(); 

            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.write(new String("Message from server").getBytes());
            
            outputStream.flush();
            outputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}