package inventory;

import org.junit.Test;

import static org.junit.Assert.*;

public class LetterInventoryTest
{
    @Test
    public void testAdd()
    {
        LetterInventory inv = new LetterInventory();
        inv.add('a');
        inv.add('a');
        assertEquals(2, inv.get('a'));

        inv.add('?');
        assertEquals(-1, inv.get('?'));
    }

    @Test
    public void testSubtract()
    {
        LetterInventory inv = new LetterInventory();
        inv.add('a');
        inv.subtract('a');
        assertEquals(0, inv.get('a'));
    }

}