import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Inventory {
    private List<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    // Adds an item to the inventory
    public void addItem(Item item) {
        items.add(item);
    }

    // Displays the inventory
    public void display() {
        if (items.isEmpty()) {
            System.out.println("(empty)");
        } else {
            for (Item i : items) {
                System.out.println("- " + i);
            }
        }
        System.out.println();
    }


    public void combineItems(String name1, String name2) {
        boolean found1 = false;
        boolean found2 = false;

        Iterator<Item> iter = items.iterator();
        while (iter.hasNext()) {
            Item current = iter.next();
            if (!found1 && current.getName().equals(name1)) {
                // How do you track which item you found?
                found1 = true;
                // How do you remove it safely?
                iter.remove();
            } else if (!found2 && current.getName().equals(name2)) {
                found2 = true;
                iter.remove();
            }
        }

        // After the loop, check if both were found.
        if (found1 && found2) {
            // If so, add the new combined item.
            Item combined = new Item(name1 + " + " + name2);
            items.add(combined);
            System.out.println("Combined " + name1 + " and " + name2 + " into " + combined);
        } else {
            System.out.println("Barista panic: we’re out of stock, order canceled!");
        }
        // What happens if you add the new item inside the loop?
        System.out.println();
    }
}

