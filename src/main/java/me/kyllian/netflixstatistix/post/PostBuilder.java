package me.kyllian.netflixstatistix.post;


import me.kyllian.netflixstatistix.controllers.Controller;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PostBuilder {

    private boolean localTesting = false; // State for testing

    private HttpClient httpClient;
    private HttpPost httpPost;
    private List<NameValuePair> attributes;


    /**
     * Initializes PostBuilder, sets up post request and starts accepting data by calling
     */
    public PostBuilder() {
        httpClient = HttpClients.createDefault();
        httpPost = new HttpPost(localTesting ? "http://localhost:8080" : "https://netflixstatistixserver.herokuapp.com");
        attributes = new ArrayList<>();
    }

    /**
     *
     * @param identifier Sends information to server what data should be used for
     * @return self
     */
    public PostBuilder withIdentifier(String identifier) {
        attributes.add(new BasicNameValuePair("identifier", identifier));
        return this;
    }

    /**
     *
     * @param name Identifier of the given value
     * @param value Data that the server can handle
     * @return self
     */

    public PostBuilder withAttribute(String name, String value) {
        attributes.add(new BasicNameValuePair(name, value));
        return this;
    }

    /**
     * Handles sending the post request to the server
     * @param controller controller to handle response with
     */

    public void post(Controller controller) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            String responseString = null;
            try {
                httpPost.setEntity(new UrlEncodedFormEntity(attributes, "UTF-8"));
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    responseString = EntityUtils.toString(entity);
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }
            controller.handleResponse(responseString);
        });
    }

}
