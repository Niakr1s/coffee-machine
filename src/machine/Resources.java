package machine;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Resources {
    private int water = 200;
    private int milk = 50;
    private int beans = 15;
    private int cups;

    Resources(int water, int milk, int beans, int cups) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
    }

    public Resources plus(Resources rhs) {
        return new Resources(
                water + rhs.water,
                milk + rhs.milk,
                beans + rhs.beans,
                cups + rhs.cups
        );
    }

    public Resources minus(Resources rhs) {
        return new Resources(
                water - rhs.water,
                milk - rhs.milk,
                beans - rhs.beans,
                cups - rhs.cups
        );
    }

    public Resources multiply(int by) {
        return new Resources(
                water * by,
                milk * by,
                beans * by,
                cups * by
        );
    }

    public int getAvailableCups(Resources resourcesInOneCup) {
        int cups = 0;
        Resources tmp = minus(resourcesInOneCup);
        while (!tmp.isLackingIngredients()) {
            cups++;
            tmp = tmp.minus(resourcesInOneCup);
        }
        return cups;
    }

    public boolean isLackingIngredients() {
        return water <= 0 || milk <= 0 || beans <= 0 || cups <= 0;
    }

    public List<String> getLackingIngredients() {
        List<String> lackingValues = new ArrayList<>();
        if (water <= 0) {
            lackingValues.add("water");
        }
        if (milk <= 0) {
            lackingValues.add("milk");
        }
        if (beans <= 0) {
            lackingValues.add("beans");
        }
        if (cups <= 0) {
            lackingValues.add("cups");
        }
        return lackingValues;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getBeans() {
        return beans;
    }

    public int getCups() {
        return cups;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public void setBeans(int beans) {
        this.beans = beans;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    public static class Builder {
        private final Resources resources;

        public Builder() {
            this.resources = new Resources(0, 0, 0, 0);
        }

        public void setWater(int water) {
            resources.setWater(water);
        }
        public void setMilk(int milk) {
            resources.setMilk(milk);
        }
        public void setBeans(int beans) {
            resources.setBeans(beans);
        }
        public void setCups(int cups) {
            resources.setCups(cups);
        }

        public Resources build() {
            return resources;
        }
    }

}
