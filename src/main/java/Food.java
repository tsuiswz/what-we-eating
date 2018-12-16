

public class Food {
    private String name;
    private float price;

    public Food(String name, float price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food Name: " + name + ", Price: " + price;
    }
}
