package test.pivotal.pal.tracker.support;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;


public class HttpClient {

    private static final MediaType JSON = MediaType.parse("application/json");

    private final OkHttpClient okHttp = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();
    
 

 @Test 
 public void dummyTest() {
	 
 }

    public Response get(String url) {
        return fetch(new Request.Builder().url(url));
    }

    public Response post(String url, Map<String, Object> jsonBody) {
        try {
            Request.Builder reqBuilder = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON, objectMapper.writeValueAsString(jsonBody)));

            return fetch(reqBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Response put(String url, Map<String, Object> jsonBody) {
        try {
            Request.Builder reqBuilder = new Request.Builder()
                .url(url)
                .put(RequestBody.create(JSON, objectMapper.writeValueAsString(jsonBody)));

            return fetch(reqBuilder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Response delete(String url) {
        return fetch(new Request.Builder().delete().url(url));
    }


    private Response fetch(Request.Builder requestBuilder) {
        try {
            Request request = requestBuilder.build();

            okhttp3.Response response = okHttp.newCall(request).execute();
            ResponseBody body = response.body();

            if (body == null) {
                return new Response(response.code(), "");
            }

            return new Response(response.code(), body.string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

