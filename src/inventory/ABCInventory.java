package inventory;

import java.util.*;
import java.io.*;

/**
 * This class will keep track of counts for the letters a,A,b,B,c,C
 * ABCInventory 'is-a' Inventory
 * Class implements Interface
 */
public class ABCInventory implements Inventory
{
    // instance fields
    private int aCount;
    private int bCount;
    private int cCount;


    /**
     * default constructor initializes all counts to zero
     * Remember: java will provide this if we do not include in the file
     */
    public ABCInventory()
    {
        aCount = 0;
        bCount = 0;
        cCount = 0;
    }


    /**
     * increments the count of the character c in the inventory
     *
     * @param c character to track in inventory
     */
    @Override
    public void add(char c)
    {
        // is character parameter a letter?
        if (Character.isLetter(c))
        {
            //convert parameter c to lowercase
            c = Character.toLowerCase(c);
            switch (c)
            {
                case 'a':
                    aCount++;
                    break;
                case 'b':
                    bCount++;
                    break;
                case 'c':
                    cCount++;
                    break;
                default:
                    break;
            } // end of switch statement
        }
    }

    /**
     * decrements the count of the character c in the inventory
     *
     * @param c character to track in inventory
     */

    @Override
    public void subtract(char c)
    {
        // is character parameter a letter?
        if (Character.isLetter(c))
        {
            //convert parameter c to lowercase
            c = Character.toLowerCase(c);
            switch (c)
            {
                case 'a':
                    if (aCount > 0)
                        aCount--;
                    break;
                case 'b':
                    if (bCount > 0)
                        bCount--;
                    break;
                case 'c':
                    if (cCount > 0)
                        cCount--;
                    break;
                default:
                    break;
            } // end of switch statement
        }
    }

    /**
     * returns a count of the letter in the inventory, -1 otherwise
     *
     * @param c character in inventory
     * @return a count of the character in the inventory or -1 if c not in inventory
     */
    @Override
    public int get(char c)
    {
        // is character parameter a letter?
        if (Character.isLetter(c))
        {
            //convert parameter c to lowercase
            c = Character.toLowerCase(c);
            switch (c)
            {
                case 'a':
                    return aCount;
                case 'b':
                    return bCount;
                case 'c':
                    return cCount;
                default:
                    System.out.println("Letter is not found in inventory.");
                    return -1;
            } // end of switch statement
        }
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
        if (count < 0)
            throw new IllegalArgumentException(count + " is < zero.");
        if (get(c) == -1)
            throw new IllegalArgumentException(c + " is not in the inventory.");

        c = Character.toLowerCase(c);

        switch (c)
        {
            case 'a':
                if (aCount >= 0)
                    aCount = count;
                break;
            case 'b':
                if (bCount >= 0)
                    bCount = count;
                break;
            case 'c':
                if (cCount >= 0)
                    cCount = count;
                break;
        }


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
        return get(c) > 0;
    }

    /**
     * returns the sum of all counts in the inventory
     *
     * @return the total count
     */
    @Override
    public int size()
    {
        return aCount + bCount + cCount;
    }

    /**
     * Returns true if this inventory is empty (all counts are 0)
     *
     * @return true if all counts are 0, false otherwise
     */
    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }


    /**
     * @return a string representation of the counts for the letters AaBbCc
     * Example: [A=3, B=4, C=5]
     */
    public String toString()
    {
        return "[A=" + aCount + ", B=" + bCount + ", C=" + cCount + "]";
    }
}
