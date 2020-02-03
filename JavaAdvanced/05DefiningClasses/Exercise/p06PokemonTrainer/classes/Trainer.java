package p06PokemonTrainer.classes;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Trainer {

    private String name;
    private int numOfBadges = 0;
    private List<Pokemon> pokemons;

    public Trainer(String name, List<Pokemon> pokemons) {
        this.name = name;
        this.pokemons = pokemons;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public int getBadges() {
        return this.numOfBadges;
    }

    public void increaseBadges() {
        this.numOfBadges++;
    }

    public boolean hasPokemonWithEl(String element) {
        boolean hasPokemonWithEl = false;

        for (Pokemon pokemon : this.pokemons) {
            if (pokemon.getElement().equals(element)) {
                hasPokemonWithEl = true;
                break;
            }
        }

        return hasPokemonWithEl;
    }

    public void damagePokemons() {
        Deque<Integer> stack = new ArrayDeque<>();

        for (Pokemon pokemon : this.pokemons) {
            int health = pokemon.getHealth();
            health -= 10;

            if (health <= 0) {
                stack.push(pokemons.indexOf(pokemon));
            } else {
                pokemon.setHealth(health);
            }
        }

        while (stack.size() > 0) {
            int index = stack.pop();
            this.pokemons.remove(index);
        }
    }

    public String getInfo() {
        return String.format(
            "%s %d %d",
            this.name, this.numOfBadges, this.pokemons.size()
        );
    }

}
