package me.kyllian.netflixstatistix.post;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class PostBuilder {

    private HttpClient httpClient;
    HttpPost httpPost;
    List<NameValuePair> attributes;


    public PostBuilder() {
        httpClient = HttpClients.createDefault();
        //httpPost = new HttpPost("http://localhost:8080");
        httpPost = new HttpPost("https://netflixstatistixserver.herokuapp.com");
        attributes = new ArrayList<NameValuePair>();
    }

    public PostBuilder withIdentifier(String identifier) {
        attributes.add(new BasicNameValuePair("identifier", identifier));
        return this;
    }

    public PostBuilder withAttribute(String name, String value) {
        attributes.add(new BasicNameValuePair(name, value));
        return this;
    }

    public String postAndGetResponse() {
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
        return responseString;
    }
}
