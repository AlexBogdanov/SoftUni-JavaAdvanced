package p03ShoppingSpree.domain;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            System.out.println(this.getName() + " can't afford " + product.getName());
            return;
        }

        this.setMoney(this.money - product.getCost());
        this.products.add(product);
        System.out.println(this.getName() + " bought " + product.getName());
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }

        this.money = money;
    }

    public List<Product> getProducts() {
        return this.products;
    }

}
