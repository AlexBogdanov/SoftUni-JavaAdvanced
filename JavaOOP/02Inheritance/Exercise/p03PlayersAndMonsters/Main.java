package p03PlayersAndMonsters;

import p03PlayersAndMonsters.hero.Hero;
import p03PlayersAndMonsters.hero.elf.Elf;
import p03PlayersAndMonsters.hero.elf.MuseElf;
import p03PlayersAndMonsters.hero.knight.BladeKnight;
import p03PlayersAndMonsters.hero.knight.DarkKnight;
import p03PlayersAndMonsters.hero.knight.Knight;
import p03PlayersAndMonsters.hero.wizard.DarkWizard;
import p03PlayersAndMonsters.hero.wizard.SoulMaster;
import p03PlayersAndMonsters.hero.wizard.Wizard;

public class Main {

    public static void main(String[] args) {
        
        Hero hero = new Hero("hero", 1);

        Elf elf = new Elf("elf", 2);
        MuseElf museElf = new MuseElf("museElf", 3);
        
        Wizard wizard = new Wizard("wizard", 2);
        DarkWizard darkWizard = new DarkWizard("darkWizard", 3);
        SoulMaster soulMaster = new SoulMaster("soulMaster", 4);
        
        Knight knight = new Knight("knight", 2);
        DarkKnight darkKnight = new DarkKnight("darkKnight", 3);
        BladeKnight bladeKnight = new BladeKnight("bladeKnight", 4);

        System.out.println(hero.toString());

        System.out.println(elf.toString());
        System.out.println(museElf.toString());
        
        System.out.println(wizard.toString());
        System.out.println(darkWizard.toString());
        System.out.println(soulMaster.toString());

        System.out.println(knight.toString());
        System.out.println(darkKnight.toString());
        System.out.println(bladeKnight.toString());

    }

}