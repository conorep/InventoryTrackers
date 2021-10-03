package inventory;

import org.junit.Test;

import static org.junit.Assert.*;

public class ABCInventoryTest
{
    @Test
    public void testValidAdd()
    {
        ABCInventory inv = new ABCInventory();
        inv.add('a');
        assertEquals(1, inv.get('a'));
        inv.add('a');
        assertEquals(2, inv.get('a'));
    }

    @Test
    public void testInvalidAdd()
    {
        ABCInventory inv = new ABCInventory();
        inv.add('z');
        assertEquals(-1, inv.get('z'));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalSetCount()
    {
        ABCInventory inv = new ABCInventory();
        inv.set('a', -1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIllegalSetCharacter()
    {
        ABCInventory inv = new ABCInventory();
        inv.set('d', 9);
    }
}