package domain.repositories;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

import domain.entities.Money;

public class MoneyRepository {

    Deque<Money> repo;

    public MoneyRepository() {
        this.repo = new ArrayDeque<>();
    }

    public void save(Money from, Money to) {
        this.repo.push(from);
        this.repo.push(to);
    }

    public List<Money> getLastRecords(int recordsCount) {
        return this.repo.stream()
            .limit(recordsCount * 2)
            .collect(Collectors.toList());
    }

}
