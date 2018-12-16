import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class GsonReaderHelper {

    public static Restaurants getRestaurants() {
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("src/main/resources/Restaurants.json"));
            Restaurants restaurants = gson.fromJson(reader, Restaurants.class);
            return restaurants;
        } catch (FileNotFoundException e)
        {
            System.out.println("Restaurant list not found. Returning null.");
            return null;
        }
    }
}