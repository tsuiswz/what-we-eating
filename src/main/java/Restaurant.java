import java.util.List;

public class Restaurant {
    private String name;
    private List<Food> foodList;

    public String getName() {
        return name;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFoods(List<Food> foodList) {
        this.foodList = foodList;
    }

    @Override
    public String toString() {
        String str = "Restaurant Name: " + name + "\n";
        for (Food food: foodList) {
            str = str + food.toString() + "\n";
        }
        return str;
    }
}
