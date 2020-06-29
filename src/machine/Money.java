package machine;

public class Money {
    private int money;

    Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public int takeAll() {
        int took = money;
        money = 0;
        return took;
    }
}
