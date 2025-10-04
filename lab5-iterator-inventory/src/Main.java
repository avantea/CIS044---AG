public class Main {
    public static void main(String[] args) {
        Inventory inv = new Inventory();

        // Add starting "menu items"
        inv.addItem(new Item("Cold Brew"));
        inv.addItem(new Item("Pumpkin Spice"));
        inv.addItem(new Item("Croissant"));
        inv.addItem(new Item("Espresso Shot"));

        System.out.println("Starbucks Inventory:");
        inv.display();

        //combining Cold Brew + Pumpkin Spice
        System.out.println("Barista attempt: Cold Brew + Pumpkin Spice...");
        inv.combineItems("Cold Brew", "Pumpkin Spice");

        System.out.println("Updated Inventory:");
        inv.display();

        //combining Croissant + Espresso Shot
        System.out.println("Barista attempt: Croissant + Espresso Shot...");
        inv.combineItems("Croissant", "Espresso Shot");

        System.out.println("Final Inventory:");
        inv.display();

        //fail
        System.out.println("Barista attempt: Pumpkin Spice + Espresso Shot...");
        inv.combineItems("Pumpkin Spice", "Espresso Shot");
    }
}


