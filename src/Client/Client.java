package Client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import Common.Debugger;
import Common.Requests.PingRequest;
import Common.Responses.PingResponse;

public class Client {
    private static final String IP = "127.0.0.1";
    private static final int PORT = 6900;

    public Client() throws IOException{
        Socket server;
        try {
           server = new Socket(IP, PORT);
        } catch (UnknownHostException e) {
            Debugger.log("Unknown host: " + IP);
            return;
        } catch (IOException e) {
            Debugger.log("No I/O");
            return;
        }
        Debugger.log("Connected to server");

        // Start thread to listen for responses
        Thread t = new Thread(new ClientThread(server));
        t.start();

        // Send a ping request
        PingRequest ping = new PingRequest();
        ClientRequest cr = new ClientRequest(server, ping);
        PingResponse r = (PingResponse)cr.getResponse();
        Debugger.log("Ping response: " + r.getDelta());


        


    }

    public static void main(String[] args) throws IOException {
        new Client();
    }
}
