package Common.Requests;

import Common.Request;

public class PingRequest implements Request {
    private int ID;
    private int typeID;
    private long time;

    
    public PingRequest() {
        this.typeID = RequestsIDs.PING;
        this.ID = (int)(Math.random() * 1000000);
        this.time = System.currentTimeMillis();
    }
    
    public long getTime() {
        return time;
    }
    
    public int getID() {
        return ID;
    }


    @Override
    public int getTypeID() {
        return typeID;
    }
}
