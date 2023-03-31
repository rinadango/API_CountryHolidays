import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ApiUrl {

    public void UrlReader(String urlToGetInfoFrom){

        try{

            URL getterUrl = new URL(urlToGetInfoFrom);

            HttpURLConnection connection = (HttpURLConnection) getterUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int status = connection.getResponseCode();
            //System.out.println(status);

            if(status == 200){

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(getterUrl.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }
                scanner.close();

                //System.out.println(informationString);

                //JSON simple library Setup with Maven is used to convert strings to JSON
                JSONParser parse = new JSONParser();
                JSONArray parsedJSON = (JSONArray) parse.parse(String.valueOf(informationString));

                //System.out.println(parsedJSON.size());

                for (int i = 0; i <= parsedJSON.size() - 1; i++) {
                    JSONObject holidayData = (JSONObject) parsedJSON.get(i);
                    //System.out.println(holidayData.get("name"));

                    //Object obj  = parser.parse(content);

                    JSONParser newParse = new JSONParser();
                    JSONArray newStuff = (JSONArray) newParse.parse(String.valueOf(holidayData.get("name")));

                    //System.out.println(newStuff);

                    JSONObject moreData = (JSONObject) newStuff.get(0);
                    System.out.println(moreData.get("text"));

                }

            } else{
                System.out.println("Nothing to read");
            }

        } catch(Exception exception){
            exception.printStackTrace();
        }

    }

    // API
    // https://www.baeldung.com/java-http-request
    // https://dzone.com/articles/how-to-implement-get-and-post-request-through-simp


    // JSON
    // https://www.youtube.com/watch?v=zZoboXqsCNw
    // https://stackoverflow.com/questions/9268099/json-array-get-length
    // https://stackoverflow.com/questions/7497980/i-want-to-add-a-jsonobject-to-a-jsonarray-and-that-jsonarray-included-in-other-j
    // https://stackoverflow.com/questions/18440098/org-json-simple-jsonarray-cannot-be-cast-to-org-json-simple-jsonobject


    // Room 4 Rita
}
