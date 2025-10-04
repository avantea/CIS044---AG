public class Main {
    public static void main(String[] args) {
        LinkedPositionalList<String> itinerary = new LinkedPositionalList<>();

        // Step 1: main Kolkata sites
        Position<String> p1 = itinerary.addLast("Victoria Memorial");
        Position<String> p2 = itinerary.addLast("Howrah Bridge");
        Position<String> p3 = itinerary.addLast("Indian Museum");

        // original itinerary
        System.out.println("Original Kolkata Itinerary:");
        printItinerary(itinerary);

        // Step 2: other stops
        Position<String> p4 = itinerary.addAfter(p1, "St. Paul's Cathedral");  // After Victoria Memorial
        Position<String> p5 = itinerary.addBefore(p2, "Princep Ghat");         // Before Howrah Bridge
        Position<String> p6 = itinerary.addAfter(p2, "Belur Math");            // After Howrah Bridge

        // Step 3: Replace
        itinerary.set(p3, "Science City");

        // Step 4: Remove
        itinerary.remove(p1);

        // Print new
        System.out.println("\nUpdated Kolkata Itinerary:");
        printItinerary(itinerary);
    }

    // Helper method
    private static void printItinerary(LinkedPositionalList<String> itinerary) {
        Position<String> current = itinerary.first();
        if (current == null) {
            System.out.println("No stops in the itinerary.");
            return;
        }

        Position<String> next = itinerary.after(current);
        System.out.print("From " + current.getElement());
        while (next != null) {
            System.out.print(", go to " + next.getElement());
            current = next;
            next = itinerary.after(current);
        }
        System.out.println(", and then back.");
    }
}


