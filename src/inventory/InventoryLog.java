package inventory;

public class InventoryLog implements Inventory
{
    /**
     * increments the count of the character c in the inventory
     *
     * @param c character to track in inventory
     */
    @Override
    public void add(char c)
    {

    }

    /**
     * decrements the count of the character c in the inventory
     *
     * @param c character to track in inventory
     */
    @Override
    public void subtract(char c)
    {

    }

    /**
     * returns a count of the letter in the inventory, zero otherwise
     *
     * @param c character in inventory
     * @return a count of the character in the inventory
     */
    @Override
    public int get(char c)
    {
        return 0;
    }

    /**
     * updates the count of the character c in the inventory (if count is zero or greater)
     *
     * @param c     character to update in inventory, throws IllegalArgumentException if character not in inventory
     * @param count number to update count with, throws IllegalArgumentException if negative
     */
    @Override
    public void set(char c, int count)
    {

    }

    /**
     * returns true if character is contained in the inventory
     *
     * @param c character
     * @return true if character in inventory, false otherwise
     */
    @Override
    public boolean contains(char c)
    {
        return false;
    }

    /**
     * returns the sum of all counts in the inventory
     *
     * @return the total count
     */
    @Override
    public int size()
    {
        return 0;
    }

    /**
     * Returns true if this inventory is empty (all counts are 0)
     *
     * @return true if all counts are 0, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return false;
    }
}
