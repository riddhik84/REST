import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PostUrlDetails {
    public static void main(String[] args) throws ClientProtocolException, IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://www.epdeveloperchallenge.com/api/init");
        StringEntity input = new StringEntity("product");
        post.setEntity(input);
        HttpResponse response = client.execute(post);
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        String line = "";
        String finalString = "";
        while ((line = rd.readLine()) != null) {
            System.out.println(line);
            finalString += line;
        }
        
        JSONParser parser = new JSONParser();
        
    	try {
     
    		Object obj = parser.parse(finalString);
     
    		JSONObject jsonObject = (JSONObject) obj;
     
//    		String name = (String) jsonObject.get("note");
//    		System.out.println(name);
    		
    		JSONObject jsonObjectMain = (JSONObject) jsonObject.get("currentCell");
    		String note = (String)jsonObjectMain.get("note");
    		System.out.println(note);
    		Long x = (Long)jsonObjectMain.get("x");
    		System.out.println("x : "+x);
    		Long y = (Long)jsonObjectMain.get("y");
    		System.out.println("y : "+y);
    		
    		String mazeGuid = (String)jsonObjectMain.get("mazeGuid");
    		System.out.println(mazeGuid);
    		String north = (String)jsonObjectMain.get("north");
    		System.out.println("north "+north);
    		String east = (String)jsonObjectMain.get("east");
    		System.out.println("east "+east);
    		String south = (String)jsonObjectMain.get("south");
    		System.out.println("south "+south);
    		String west = (String)jsonObjectMain.get("west");
    		System.out.println("west "+west);
    		
    		
//    		long age = (Long) jsonObject.get("age");
//    		System.out.println(age);
//     
    		// loop array
//    		JSONArray msg = (JSONArray) jsonObject.get("currentCell");
//    		Iterator<String> iterator = msg.iterator();
//    		while (iterator.hasNext()) {
//    			System.out.println(iterator.next());
//    		}
     
    	}  catch (ParseException e) {
    		e.printStackTrace();
    	}
     
        
    }
}
