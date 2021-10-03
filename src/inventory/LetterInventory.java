package inventory;

/**
 * This class represents an inventory of the 26 letters in the English alphabet.
 * A LetterInventory object keeps track of how many a’s, how many b’s, etc.
 * are contained in a given string.
 * For example:
 * the letter inventory for the string “Washington State” corresponds to [aaeghinnosstttw].
 * The case of the letter is ignored, so ‘s’ and ‘S’ are exactly the same.
 */
public class LetterInventory implements Inventory
{
    private static final int ALPHABET_INT = 26;

    // instance field
    private int[] letters; // letters is null here


    // default constructor - need to provide this constructor
    // so memory is constructed for array (so it is no longer null)
    public LetterInventory()
    {
        letters = new int[ALPHABET_INT];
    }


    @Override
    public void add(char c)
    {
        if (Character.isLetter(c))
        {
            c = Character.toLowerCase(c);
            // one line of code here to update the count in the letters array for char c
            // subtract ascii values to select the array position to increment
            letters[c - 'a']++;
        }
    }

    @Override
    public void subtract(char c)
    {
        if (Character.isLetter(c))
        {
            c = Character.toLowerCase(c);
            letters[c - 'a']--;
        }
    }

    @Override
    public int get(char c)
    {

        if (Character.isLetter(c))
        {
            c = Character.toLowerCase(c);
            return letters[c - 'a'];
        }
        return -1;
    }

    @Override
    public void set(char c, int count)
    {
        if(Character.isLetter(c))
        {
            c = Character.toLowerCase(c);
            letters[c - 'a'] = count;
        }
    }

    @Override
    public boolean contains(char c)
    {
        return get(c) > 0;
    }

    @Override
    public int size()
    {
        int count = 0;
        for (int letter : letters)
        {
            count += letter;
        }
        return count;
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    /**
     * Returns a String representation of the inventory with the letters all in lowercase
     * surrounded by square brackets in alphabetical order. The number of occurrences of
     * each letter matches its count in the inventory.
     * For example, an inventory of 4 a’s, 1 b, 1 k and 1 m would be represented as “[aaaabkm]”.
     *
     * @return a bracketed string representation of the letters contained in the inventory
     */
    public String toString()
    {
        // If you are concatenating many strings together, StringBuilder class
        // is often more efficient(faster)
        StringBuilder toReturn = new StringBuilder("[");

        // for every count in the letters inventory
        for (int i = 0; i < letters.length; i++)
        {
            // add each character to the string count times
            for (int count = 0; count < letters[i]; count++)
            {
                // ascii math performed here
                // Example:
                // 'a' + 0 = 'a'
                // 'a' + 1 = 'b'
                // 'a' + 2 = 'c'
                // 'a' + 25 = 'z'
                toReturn.append((char) ('a' + i));
            }
        }
        return toReturn.append("]").toString();
    }
}

