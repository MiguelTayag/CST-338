import java.util.HashMap;
import java.util.Objects;

public class Monster {
    private Integer maxHP;
    private int hp;
    private Integer xp = 10;
    private HashMap<String, Integer> items;

    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items){
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.xp = xp;
        this.items = items;
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
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return hp == monster.hp && maxHP.equals(monster.maxHP) && xp.equals(monster.xp) && items.equals(monster.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxHP, hp, xp, items);
    }

    @Override
    public String toString() {
        return "hp=" + this.getHp() + "/" + this.getMaxHP();
    }
}
