package co.edu.uptc.colasJava.models;

public class ATM {
    private int availableMoney;

    public void addMoney(int money) {
        availableMoney += money;
    }

    public boolean isMoneyAvailable() {
        return availableMoney > 0;
    }

    public void removeMoney(int money) {
        availableMoney -= money;
    }

    public int getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(int availableMoney) {
        this.availableMoney = availableMoney;
    }

}
