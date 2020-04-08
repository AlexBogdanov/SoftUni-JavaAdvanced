package motocrossWorldChampionship.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import motocrossWorldChampionship.entities.interfaces.Rider;
import motocrossWorldChampionship.repositories.interfaces.Repository;

public class RiderRepository implements Repository<Rider> {

    private Collection<Rider> repo;

    public RiderRepository() {
        this.repo = new ArrayList<>();
    }

    @Override
    public Rider getByName(String name) {
        return this.repo.stream()
            .filter(r -> r.getName().equals(name))
            .limit(1)
            .findFirst()
            .orElse(null);
    }

    @Override
    public Collection<Rider> getAll() {
        return Collections.unmodifiableCollection(this.repo);
    }

    @Override
    public void add(Rider model) {
        this.repo.add(model);
    }

    @Override
    public boolean remove(Rider model) {
        return this.repo.removeIf(r -> r.getName().equals(model.getName()));
    }

}
