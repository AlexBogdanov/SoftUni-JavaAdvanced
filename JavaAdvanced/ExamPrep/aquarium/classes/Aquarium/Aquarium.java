package aquarium.classes.Aquarium;

import java.util.LinkedHashMap;
import java.util.Map;

import aquarium.classes.Fish.Fish;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private Map<String, Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }

    public int getFishInPool() {
        return this.fishInPool.size();
    }

    public void add(Fish fish) {
        if (this.fishInPool.containsKey(fish.getName()) || this.fishInPool.size() == this.capacity) {
            return;
        }

        this.fishInPool.put(fish.getName(), fish);
    }

    public boolean remove(String name) {
        if (!this.fishInPool.containsKey(name)) {
            return false;
        }

        this.fishInPool.remove(name);
        return true;
    }

    public Fish findFish(String name) {
        if (!this.fishInPool.containsKey(name)) {
            return null;
        }

        return this.fishInPool.get(name);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(
            "Aquarium: %s ^ Size: %d",
            this.name, this.size
        )).append(System.lineSeparator());

        for (String fishName : this.fishInPool.keySet()) {
            sb.append(this.fishInPool.get(fishName).toString())
            .append(System.lineSeparator());
        }

        return sb.toString();
    }

}
