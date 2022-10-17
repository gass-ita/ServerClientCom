package Common.Responses;

import Common.Request;
import Common.Response;
import Common.Requests.PingRequest;

public class PingResponse implements Response {
    private int ID;
    private int typeID;
    private PingRequest request;
    private long time;
    private long delta;
    
    public PingResponse(int ID, PingRequest request) {
        this.typeID = ResponsesIDs.PING;
        typeID = ID;
        this.request = request;
        this.time = System.currentTimeMillis();
        this.delta = time - request.getTime();
    }

    public long getDelta() {
        return delta;
    }
    
    
    public int getID() {
        return ID;
    }


    @Override
    public int getTypeID() {
        // TODO Auto-generated method stub
        return typeID;
    }


    @Override
    public Request getRequest() {
        // TODO Auto-generated method stub
        return request;
    }
}
    

