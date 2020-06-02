package test.pivotal.pal.tracker.support;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class Response {
    public final int status;
    public final String body;

 public   Response(){
	 this.status = 0;
     this.body = "";
    	
    }
    
    public Response(int status, String body) {
    	this.status = status;
        this.body = body;
    }

    
    @Test
    public void dummyTest(){
    	
    }
    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", body='" + body + '\'' +
                '}';
    }
}
