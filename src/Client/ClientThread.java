package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import Common.Debugger;
import Common.Response;

public class ClientThread implements Runnable{
    private Socket server;
    private ObjectInputStream in;

    public ClientThread(Socket server) throws IOException{
        this.server = server;
        in = new ObjectInputStream(this.server.getInputStream());
        
    }

    @Override
    public void run() {
        while(true){
            try {
                Object o = in.readObject();
                if (o instanceof Response){
                    Response r = (Response) o;
                    ClientInfo.responses.put(r.getID(), r);
                }
            } catch (ClassNotFoundException e) {
                Debugger.err("Class not found");
            } catch (IOException e) {
                Debugger.err("No I/O");
            }
        }
        
    }

}
