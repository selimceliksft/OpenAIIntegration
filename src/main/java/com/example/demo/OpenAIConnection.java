package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class OpenAIConnection {
	
	
	public OpenAIConnection() {
		
	}
	
	
	public String chatGPT(String text) throws Exception {
    	
    	// API endpoint URL
        String url = "https://api.openai.com/v1/completions";
        
        // Open a connection to the API endpoint
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();

        // Set the request method and headers. -> 3. line has a key generated from openAI by my account. full service has a price. this is a demo.
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setRequestProperty("Authorization", "Bearer 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");

        // Create a JSON object for the request payload
        JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", text);
        data.put("max_tokens", 4000);
        data.put("temperature", 1.0);

        // Enable output and write the request payload to the connection's output stream
        con.setDoOutput(true);
        con.getOutputStream().write(data.toString().getBytes());

        // Read the API response from the connection's input stream
        String output = new BufferedReader(new InputStreamReader(con.getInputStream())).lines()
                .reduce((a, b) -> a + b).get();

        // Extract and return the generated answer from the API response
        return (new JSONObject(output).getJSONArray("choices").getJSONObject(0).getString("text"));
        
    }
	
	

}
