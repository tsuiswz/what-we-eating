import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WhatWeEating {
    private static Restaurants restaurants;
    public static void main(String[] args) {
        restaurants = GsonReaderHelper.getRestaurants();
        System.out.println(restaurants.toString());
        boolean isDone = false;
        while (!isDone) {
            isDone = chooseOptions();
        }
    }

    private static Restaurant getRandomRestaurant(Restaurants restaurants) {
        List<Restaurant> restaurantList = restaurants.getRestaurantList();
        Random rand = new Random();
        Restaurant randomRestaurant = restaurantList.get(rand.nextInt(restaurantList.size()));
        return randomRestaurant;
    }

    private static Food getRandomFood(Restaurant restaurant){
        List<Food> foodList = restaurant.getFoodList();
        Random rand = new Random();
        Food randomFood= foodList.get(rand.nextInt(foodList.size()));
        return randomFood;
    }

    private static boolean chooseOptions(){
        System.out.print("Choose an option: [1]Where are we eating today, [2]What are we eating today, [3]Choose restaurant and get random food: ");
        Scanner user_input = new Scanner(System.in);
        String stringInput = user_input.next();
        int input = Integer.parseInt(stringInput);
        if (input==1) {
            chooseRandomRestaurant();
        } else if (input == 2){
            chooseRandomFood();
        } else if (input == 3){
            return chooseRandomFoodGivenRestaurant();
        } else {
            System.out.println("You are trolling me. Please enter option 1, 2, or 3 thnx");
            return false;
        }
        return true;
    }

    private static void chooseRandomRestaurant(){
        Restaurant restaurant;
        restaurant = getRandomRestaurant(restaurants);
        String restaurantName = restaurant.getName();
        System.out.println("You will be eating at " + restaurantName + ". This is not an option...");
        System.out.println(restaurant.toString());
    }

    private static void chooseRandomFood(){
        Restaurant restaurant;
        restaurant = getRandomRestaurant(restaurants);
        String restaurantName = restaurant.getName();
        Food randomFood = getRandomFood(restaurant);
        System.out.println("You will be eating at " + restaurantName + ".");
        System.out.println("You will be eating:");
        System.out.println(randomFood.toString());
    }

    private static boolean chooseRandomFoodGivenRestaurant(){
        System.out.println("Enter restaurant name: ");
        Scanner user_input = new Scanner(System.in);
        String restaurantName = user_input.next();

        Restaurant restaurant = null;
        List<Restaurant> restaurantList = restaurants.getRestaurantList();
        for (Restaurant r: restaurantList){
            if (r.getName().equals(restaurantName)){
                restaurant = r;
            }
        }
        if (restaurant==null) {
            System.out.println("The restaurant name given is not found. Please double check spelling.");
            return false;
        }
        Food randomFood = getRandomFood(restaurant);
        System.out.println("You will be eating at " + restaurantName + ".");
        System.out.println("You will be eating:");
        System.out.println(randomFood.toString());
        return true;
    }
}
