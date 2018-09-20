import java.net.ServerSocket;
import java.net.Socket;


class Jqueue {

    
    public static void main(String args[]) {
        int port =0,backlog = 0;
        try {
            port = Integer.parseInt(args[0]);
            backlog = Integer.parseInt(args[1]);
        }
        catch (Exception e) {
            System.out.println("invalid arguments for port / backlog");
            System.exit(0);
        }

        new Jqueue().start(port,backlog);

    }

    private void start(int port, int backlog) {

        try {
            ServerSocket serverSocket =  new ServerSocket(port,backlog);
            System.out.println("Queue started on port "+port);

            while(true) {

                Socket socket = serverSocket.accept();
                Thread thread =  new Thread(new RequestHandler(socket));
                thread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}