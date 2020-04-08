package motocrossWorldChampionship.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.repositories.interfaces.Repository;

public class MotorcycleRepository implements Repository<Motorcycle> {

    private Collection<Motorcycle> repo;

    public MotorcycleRepository() {
        this.repo = new ArrayList<>();
    }

    @Override
    public Motorcycle getByName(String name) {
        return this.repo.stream()
            .filter(m -> m.getModel().equals(name))
            .limit(1)
            .findFirst()
            .orElse(null);
    }

    @Override
    public Collection<Motorcycle> getAll() {
        return Collections.unmodifiableCollection(this.repo);
    }

    @Override
    public void add(Motorcycle model) {
        this.repo.add(model);
    }

    @Override
    public boolean remove(Motorcycle model) {
        return this.repo.removeIf(m -> m.getModel().equals(model.getModel()));
    }

}
