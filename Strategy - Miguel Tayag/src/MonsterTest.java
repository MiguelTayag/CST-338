import Monsters.Imp;
import Monsters.Kobold;
import Monsters.Monster;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/*Name: Miguel Tayag
 *CST-338
 *This is a test for the Monsters.Monster class and its children classes
 */
class MonsterTest {
    List<Monster> monsters;
    HashMap<String, Integer> items;
    @BeforeEach
    void setUp() {
        items = new HashMap<>();
        monsters = new ArrayList<>();
        monsters.add(new Imp(15, 20, items));
        monsters.add(new Kobold(1, 5, items));
    }

    @Test
    void getMaxHP() {
        assertEquals(15, monsters.get(0).getMaxHP());
        assertEquals(1, monsters.get(1).getMaxHP());
    }

    @Test
    void getHp() {
        assertEquals(15, monsters.get(0).getHp());
        assertEquals(1, monsters.get(1).getHp());
    }

    @Test
    void setHp() {
        monsters.get(0).setHp(2);
        monsters.get(1).setHp(5);
        assertEquals(2, monsters.get(0).getHp());
        assertEquals(5, monsters.get(1).getHp());
    }

    @Test
    void getXp() {
        assertEquals(20, monsters.get(0).getXp());
        assertEquals(5, monsters.get(1).getXp());
    }

    @Test
    void getItems() {
        HashMap<String, Integer> tester = new HashMap<>();
        monsters.get(0).getItems().put("gold", 5);
        assertNotEquals(monsters.get(0).getItems(), tester);
        tester.put("gold", 5);
        assertEquals(monsters.get(0).getItems(), tester);

    }

    @Test
    void setItems() {
        HashMap<String, Integer> tester = new HashMap<>();
        tester.put("gold", 7);
        assertNotEquals(monsters.get(0).getItems(), tester);
        monsters.get(0).setItems(tester);
        assertEquals(monsters.get(0).getItems(), tester);
    }

    @Test
    void testEquals() {
        assertNotEquals(true, monsters.get(0).equals(monsters.get(1)));
        assertEquals(false, monsters.get(0).equals(monsters.get(1)));
    }

    @Test
    void testHashCode() {
        assertNotEquals(monsters.get(0).hashCode(), monsters.get(1).hashCode());
        assertEquals(monsters.get(0).hashCode(), monsters.get(0).hashCode());
    }

    @Test
    void testToString() {
        String tester = "Monsters.Imp has : hp=" + monsters.get(1).getHp() + "/" + monsters.get(1).getMaxHP();
        assertNotEquals(tester, monsters.get(0).toString());
        assertEquals(tester, monsters.get(1).toString());
    }

    @Test
    void testKoboldToString(){
        assertEquals("Monsters.Kobold has : hp=1/1", monsters.get(1).toString());
    }

    @Test
    void testImpToString(){
        assertEquals("Monsters.Imp has : hp=15/15", monsters.get(0).toString());
    }
}