package com.github.AlexBogdanov;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> storage;

    public Instock() {
        this.storage = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.storage.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.storage.contains(product);
    }

    @Override
    public void add(Product product) {
        Product prod = this.storage.stream()
            .filter(p -> p.getLabel().equals(product.label))
            .findFirst()
            .orElse(null);

        if (prod != null) {
            throw new IllegalArgumentException("There is prod " + prod.label + " in store");
        }

        this.storage.add(product);
    }

    @Override
    public void changeQuantity(String prodLabel, int quantity) {
        Product prod = this.storage.stream()
            .filter(p -> p.getLabel().equals(prodLabel))
            .findFirst()
            .orElse(null);

        if (prod == null) {
            throw new IllegalArgumentException("Invalid product: " + prodLabel);
        }

        prod.setQuantity(prod.getQuantity() + quantity);;
    }

    @Override
    public Product find(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index cannot be a negative number");
        }

        if (index > this.storage.size()) {
            throw new IndexOutOfBoundsException("Index should be between " + 0 + " and  " + this.storage.size());
        }

        return this.storage.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        Product prod = this.storage.stream()
            .filter(p -> p.getLabel().equals(label))
            .findFirst()
            .orElse(null);

        if (prod == null) {
            throw new IllegalArgumentException("Invalid product: " + label);
        }

        return prod;
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count <= 0 || count > this.storage.size()) {
            return new ArrayList<Product>();
        }

        return this.storage.stream()
            .sorted((p1, p2) -> p1.getLabel().compareTo(p2.getLabel()))
            .limit(count)
            .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.storage.stream()
            .filter(p -> p.getPrice() >= lo && p.getPrice() <= hi)
            .sorted((p1, p2) -> {
                if (p1.getPrice() > p2.getPrice()) { return -1; }
                if (p1.getPrice() < p2.getPrice()) { return 1; }
                return 0;
            }).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.storage.stream()
            .filter(p -> p.getPrice() == price)
            .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Count should be a number");
        }

        if (count > this.storage.size()) {
            throw new IllegalArgumentException("Count should be between " + 1 + " and " + this.storage.size());
        }

        var prods = this.storage.stream()
            .sorted((p1, p2) -> {
                if (p1.getPrice() > p2.getPrice()) { return -1; }
                if (p1.getPrice() < p2.getPrice()) { return 1; }
                return 0;
            })
            .limit(count)
            .collect(Collectors.toList());

        if (prods.size() < count) {
            throw new IllegalArgumentException("Not enough products matching the criteria");
        }

        return prods;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.storage.stream()
            .filter(p -> p.getQuantity() == quantity)
            .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        throw new UnsupportedOperationException();
    }
}
