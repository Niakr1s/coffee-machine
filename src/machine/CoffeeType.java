package machine;

public enum CoffeeType {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final Resources resources;
    private final int price;

    CoffeeType(int waterInCup, int milkInCup, int beansInCup, int price) {
        resources = new Resources(waterInCup, milkInCup, beansInCup, 1);
        this.price = price;
    }

    public Resources getResources() {
        return resources;
    }

    public int getPrice() {
        return price;
    }
}
