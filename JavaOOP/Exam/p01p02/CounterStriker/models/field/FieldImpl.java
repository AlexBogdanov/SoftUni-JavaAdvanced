package CounterStriker.models.field;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.*;

import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

public class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = createTeam(Terrorist.class.getSimpleName(), players);
        List<Player> counterTerrorists = createTeam(CounterTerrorist.class.getSimpleName(), players);

        while (isTeamAlive(terrorists) && isTeamAlive(counterTerrorists)) {
            playersAttack(terrorists, counterTerrorists);
            counterTerrorists = filterPlayers(counterTerrorists);
            playersAttack(counterTerrorists, terrorists);
            terrorists = filterPlayers(terrorists);
        }

        if (isTeamAlive(counterTerrorists)) {
            return COUNTER_TERRORIST_WINS;
        }

        return TERRORIST_WINS;
    }

    private List<Player> filterPlayers(List<Player> players) {
        return players.stream()
            .filter(p -> p.isAlive())
            .collect(Collectors.toList());
    }

    private void playersAttack(List<Player> attackers, List<Player> deffenders) {
        for (Player attacker : attackers) {
            int points = attacker.getGun().fire();

            for (Player defender : deffenders) {
                defender.takeDamage(points);
            }
        }
    }

    private boolean isTeamAlive(List<Player> players) {
        return players.stream()
            .filter(p -> p.isAlive())
            .filter(p -> p.getHealth() > 0)
            .count() > 0 ? true : false;
    }

    private List<Player> createTeam(String teamName, Collection<Player> players) {
        return players.stream()
            .filter(p -> p.getClass().getSimpleName().equals(teamName))
            .filter(p -> p.isAlive())
            .collect(Collectors.toList());
    } 

}
