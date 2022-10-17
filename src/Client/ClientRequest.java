package Client;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import Common.Request;
import Common.Response;

public class ClientRequest {
    private static long defaultTimeout = 500;

    private Request request;
    private Socket server;
    private ObjectOutputStream out;
    private long timeout; 

    public ClientRequest(Socket server, Request request) throws IOException {
        this.request = request;
        this.server = server;
        out = new ObjectOutputStream(this.server.getOutputStream());
        out.writeObject(this.request);
        timeout = defaultTimeout;
    }

    public Response getResponse() {
        //try to get the response until it is available with a timeout
        int timeout = 0;
        while (timeout < this.timeout) {
            if (ClientInfo.responses.containsKey(request.getID())) {
                return ClientInfo.responses.get(request.getID());
            }
            timeout++;
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        throw new RuntimeException("Timeout");        
    }
        
}

