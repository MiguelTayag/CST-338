package Monsters;

import Abilities.Attack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public class Monster {
    private Integer maxHP;
    private int hp;
    private Integer xp = 10;
    private HashMap<String, Integer> items;
    Integer agi = 10;
    Integer def = 10;
    Integer str = 10;
    Attack attack;

    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items){
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
    }

    Integer getAttribute(Integer min, Integer max){
        Random rand = new Random();
        if(min > max){
            Integer temp = min;
            min = max;
            max = temp;
        }
        return rand.nextInt(max - min) + min;
    }

    boolean takeDamage(Integer damage){
        if(damage > 0){
            this.hp -= damage;
            System.out.println("The creature was hit for " + damage + " damage!");
            if(this.hp <= 0){
                this.hp = 0;
                System.out.println("Oh no! The creature has perished.");
                System.out.println(this.toString());
                return false;
            }
        }
        return true;
    }

    public Integer attackTarget(Monster target){
        Integer damage = this.attack.attack(target);
        target.takeDamage(damage);
        return damage;
    }

    public Integer getAgi() {
        return agi;
    }

    public Integer getDef() {
        return def;
    }

    public Integer getStr() {
        return str;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Integer getXp() {
        return xp;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monster)) return false;
        Monster monster = (Monster) o;
        return hp == monster.hp && maxHP.equals(monster.maxHP) && xp.equals(monster.xp) && items.equals(monster.items) && agi.equals(monster.agi) && def.equals(monster.def) && str.equals(monster.str) && attack.equals(monster.attack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxHP, hp, xp, items, agi, def, str, attack);
    }

    @Override
    public String toString() {
        return "hp=" + this.getHp() + "/" + this.getMaxHP();
    }
}
