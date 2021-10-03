package drivers;

import java.util.*;
import java.io.*;

import inventory.*;

/**
 * This class creates and populates Inventory objects with data file contents
 */
public class InventoryEngine
{

    public static void main(String[] args)
    {
        LetterInventory inventory = new LetterInventory();
        testInventory(inventory);

        //populate(inventory, "data/hello.txt");
        //System.out.println("Expected [A=0, B=0, C=0] size=0 " + inventory + " size=" + inventory.size());

        //populate(inventory,"data/alphabet.txt");
        //System.out.println("Expected [A=5, B=5, C=5] size=15 "+inventory+" size="+inventory.size());

        //populate(inventory,"data/ipsum.txt");
        //System.out.println("Expected [A=7, B=1, C=4] size=12 "+inventory+" size="+inventory.size());
    }

    /**
     * This method reads a text file and produces an Inventory object based on the file contents
     *
     * @param inventory object used to keep track of various characters
     * @param fileName  name of file holding the characters
     */
    public static void populate(Inventory inventory, String fileName)
    {
        // read in contents of file
        // use a try-with statement to open the file so that it's automatically closed (I don't have to worry about closing)
        try (Scanner fileIn = new Scanner(new File(fileName)))
        {
            // file is open here
            while (fileIn.hasNextLine())
            {
                String line = fileIn.nextLine();
                // parse each line in file into individual chars
                for (char c : line.toCharArray())
                {
                    inventory.add(c);
                }
            }

        } catch (FileNotFoundException e)
        {
            System.out.println("File Not Found " + fileName);
        }


        // add each individual char to inventory object

    }

    /**
     * This method tests the various methods in the inventory
     *
     * @param inventory object used to keep track of various characters
     */
    public static void testInventory(Inventory inventory)
    {
        // test add/size method
        inventory.add('a');
        inventory.add('z');
        inventory.add('a');
        inventory.add('B');
        System.out.println(inventory + " size:" + inventory.size());

        // test subtract method
        inventory.subtract('a');
        System.out.println(inventory);

        // test get method
        System.out.println("GET Expected Count of b's: 1   " + inventory.get('b'));

        // test contains method
        System.out.println("CONTAINS Expected Contains c: false " + inventory.contains('c'));
        System.out.println("CONTAINS Expected Contains a: true " + inventory.contains('a'));

        System.out.println("Expected size: 2 " + inventory.size());

        // test set method with letter in inventory
        inventory.set('c', 3);
        System.out.println("SET Expected [A=1, B=1, C=3] " + inventory);

        // test set method with letter not in inventory
        try
        {
            inventory.set('z', 4);
        } catch (IllegalArgumentException e)
        {
            System.out.println("Cannot set inventory to z");
        }

        System.out.println("Expected size: 2 " + inventory.size());

        // test isEmpty method
        System.out.println("IS EMPTY Expected isEmpty(): false " + inventory.isEmpty());


    }

}