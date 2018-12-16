import java.util.List;

public class Restaurants {
    private List<Restaurant> restaurantList;

    public Restaurants(List<Restaurant> rl) { restaurantList = rl;}

    public List<Restaurant> getRestaurantList() {
        return restaurantList;
    }
    public void setRestaurantList(List<Restaurant> restaurantList) {
        this.restaurantList = restaurantList;
    }

    @Override
    public String toString() {
        String str = "All Restaurants:\n";
        for (Restaurant restaurant: restaurantList) {
            str = str + restaurant.toString() + "\n";
        }
        return str;
    }
}
