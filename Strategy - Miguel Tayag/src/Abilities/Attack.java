package Abilities;

import Monsters.Monster;

public interface Attack extends Ability{
    abstract Integer attack(Monster target);
}
