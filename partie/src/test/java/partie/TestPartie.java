package partie;

import org.testng.annotations.Test;
import plateau.Placement;

import java.util.*;

import static org.testng.AssertJUnit.*;

public class TestPartie
{
    Partie p = new Partie();
    ArrayList<Integer> players = new ArrayList<>();
    Map<Integer, Integer> points = new TreeMap<>();

    void setupPlayers()
    {
        players.add(1);
        players.add(2);
        players.add(3);
        players.add(4);
    }

    ArrayList<Placement> getMot()
    {
        ArrayList<Placement> mot = new ArrayList<>();
        mot.add(new Placement('c', 6, 7));
        mot.add(new Placement('h', 7, 7));
        mot.add(new Placement('a', 8, 7));
        mot.add(new Placement('t', 9, 7));

        return mot;
    }

    /***
     * Tests getWinners and sortByValue
     */
    @Test
    void getWinnersTest()
    {
        points.put(1, 34);
        points.put(2, 20);
        points.put(3, 50);
        points.put(4, 51);
        var ordered = p.sortByValue(points);
        var winner = p.getWinners(ordered);

        assertEquals(winner, 4);

        points.put(1, 70);
        points.put(2, 60);
        ordered = p.sortByValue(points);
        winner = p.getWinners(ordered);

        assertEquals(winner, 1);
    }

    @Test
    void isGameOnTest()
    {
        setupPlayers();
        points.put(1, 34);
        points.put(2, 20);
        points.put(3, 49);
        points.put(4, 0);
        var ordered = p.sortByValue(points);

        assertTrue(p.isGameOn(players, ordered));

        points.put(4, 50);
        ordered = p.sortByValue(points);

        assertFalse(p.isGameOn(players, ordered));
    }

    @Test
    void initMainTest()
    {
        var main = p.initMain();
        assertEquals(main.size(), 7);
    }

    @Test
    void attribuerPointsTest()
    {
        var mot = getMot();
        assertEquals(p.attribuerPoints(mot), 9);
    }

    @Test
    void placerMotTest()
    {
        assertEquals(Character.MIN_VALUE, (char) p.board.getCentre().getValeur());
        for (var aPlacement : getMot())
        {
            assertEquals(Character.MIN_VALUE, (char) p.board.getCase(aPlacement.getX(), aPlacement.getY()).getValeur());
        }
        p.placerMot(getMot());
        assertFalse(Character.MIN_VALUE == p.board.getCentre().getValeur());
        for (var aPlacement : getMot())
        {
            assertFalse(Character.MIN_VALUE == p.board.getCase(aPlacement.getX(), aPlacement.getY()).getValeur());
        }
    }

    @Test
    void removeFromMainTest()
    {
        Queue<Character> main = new LinkedList<>();
        main.add('l');
        main.add('a');
        main.add('a');
        main.add('a');
        main.add('a');
        main.add('a');
        main.add('a');

        //check if initially 7
        assertEquals(main.size(), 7);

        // check if l is removed
        main = p.removeFromMain(main, 'l');
        assertEquals(main.size(), 6);

        //try removing something thats not in queue
        main = p.removeFromMain(main, 'l');
        assertEquals(main.size(), 6);

        //remove a letter that appears multiple times
        main = p.removeFromMain(main, 'a');
        assertEquals(main.size(), 5);
    }

    @Test
    void caseToStringTest()
    {
        assertEquals("chat", p.caseToString(getMot()));
    }

    @Test
    void getMainTest()
    {
        Queue<Character> main = new LinkedList<>();
        main.add('l');
        main.add('a');
        main.add('a');
        main.add('a');
        main.add('a');
        main.add('a');
        main.add('a');

        assertEquals("laaaaaa", p.getMain(main));
    }
}
