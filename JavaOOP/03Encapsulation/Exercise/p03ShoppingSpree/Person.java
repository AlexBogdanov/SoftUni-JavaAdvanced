package p03ShoppingSpree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Person {

    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person(String name, double money) throws IllegalArgumentException {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            System.out.println(String.format(
                "%s can`t afford %s",
                this.getName(),
                product.getName()
            ));
            return;
        }

        this.setMoney(this.money - product.getCost());
        bagOfProducts.add(product);
        System.out.println(String.format(
            "%s bought %s",
            this.getName(),
            product.getName()
        ));
    }

    public List<Product> getBagOfProducts() {
        return Collections.unmodifiableList(this.bagOfProducts);
    }

    public String getListedProducts() {
        String[] names = new String[this.bagOfProducts.size()];

        for (int i = 0; i < names.length; i++) {
            names[i] = this.bagOfProducts.get(i).getName();
        }

        return String.join(", ", Arrays.asList(names));
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }

        if (name.length() < 1) {
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

}
