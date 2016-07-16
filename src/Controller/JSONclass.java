package Controller;
import Model.Deck;
import Model.Flashcard;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 *
 * @author Anthony
 */
public class JSONclass {
    
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String USER_LOG_GET_URL = "http://jsontest.localhost/public/js/user_log.txt";
    private static final String ITEMS_GET_URL = "http://jsontest.localhost/public/js/items.txt";
    private static final String POST_URL = "http://jsontest.localhost/index.php/welcome/addItemJson";
 
    public void AddDeckJSON() throws IOException{
        Deck item = new Deck();
        Gson g = new Gson();
        List<Deck> list = new ArrayList<Deck>();
        list = item.decks();
        List<Deck> listOfItems = new ArrayList<Deck>();
        Integer counter = list.size();
        Integer i = 0;
        while(i < counter)
        {
            listOfItems.add(list.get(i));
            i++;
        }
        Set<Deck> itemSet = new HashSet<Deck>();
        for(Iterator iterator = list.iterator(); iterator.hasNext();)
        {
            Deck itemOld = (Deck) iterator.next(); 
            itemSet.add(itemOld);
        }
        String json = "array=" + itemSet.toString();
        sendPOST(json, POST_URL);
        writeJsonToFile(itemSet.toString());
    }
//    
//    public List<Item> getItemsJSON() throws IOException
//    {
//        Gson g = new Gson();
//        String output = sendGET(ITEMS_GET_URL);
//        System.out.println(output);
//        Type items = new TypeToken<List<Item>>() {}.getType();
//        List<Item> listOfItems = g.fromJson(output, items);
//        return listOfItems;
//    }
    
    private static String sendGET(String url) throws IOException {
        String output = "";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        //System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
 
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            output = response.toString();
            // print result
            //System.out.println(response.toString());
        } else {
            //System.out.println("GET request not worked");
        }
        return output;
    }
    
    private static void sendPOST(String json, String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
 
        // For POST only - START
        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        os.close();
        // For POST only - END
 
        int responseCode = con.getResponseCode();
        //System.out.println("POST Response Code :: " + responseCode);
 
        if (responseCode == HttpURLConnection.HTTP_OK) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
 
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
 
             //print result
            System.out.println(response.toString());
        } else {
            System.out.println("POST request not worked");
        }
    }
    
    private static void writeJsonToFile(String Json) throws IOException
    {
        try (FileWriter file = new FileWriter("./items.txt")) {
			file.write(Json);
			System.out.println("Successfully Copied JSON Object to File...");
		}
    }
}
