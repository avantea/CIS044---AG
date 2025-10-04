public class Item {
    private String name; // name of the item

    // Constructor
    public Item(String name) {
        this.name = name;
    }

    // Getter method
    public String getName() {
        return name;
    }

    // toString method for printing
    @Override
    public String toString() {
        return name;
    }
}
