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

                    JSONArray newStuff = (JSONArray) parse.parse(String.valueOf(holidayData.get("name")));
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

}
