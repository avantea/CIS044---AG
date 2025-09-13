import java.util.Random;

// Step 1: Create the abstract parent class
abstract class Animal {
    public abstract String toString();
}

// Step 2: Create the concrete animal classes
class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

// Main class to run the simulation
public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
    }

    public void populate(int bears, int fish) {
        int n = river.length;
        if (bears + fish > n) throw new IllegalArgumentException();
        for (int i = 0; i < bears; ) {
            int idx = random.nextInt(n);
            if (river[idx] == null) { river[idx] = new Bear(); i++; }
        }
        for (int i = 0; i < fish; ) {
            int idx = random.nextInt(n);
            if (river[idx] == null) { river[idx] = new Fish(); i++; }
        }
    }

    public void runStep() {
        // This is the core logic for a single time step.
        // 1. Create a new array for the next state.
        // 2. Iterate through the current river array.
        // 3. For each animal, decide its next mov4e.
        // 4. Handle collisions and place animals in the new array.
        // 5. Replace the old river with the new one.
        Animal[] next = new Animal[river.length];
        char[] births = new char[river.length];
        int birthCount = 0;

        for (int i = 0; i < river.length; i++) {
            Animal a = river[i];
            if (a == null) continue;
            int move = randomMove();
            int target = i + move;
            if (target < 0 || target >= river.length) target = i;

            if (next[target] == null) {
                next[target] = a;
            } else {
                Animal b = next[target];
                boolean aBear = (a instanceof Bear);
                boolean bBear = (b instanceof Bear);
                if (aBear == bBear) {
                    if (birthCount < births.length) births[birthCount++] = aBear ? 'B' : 'F';
                } else {
                    next[target] = new Bear();
                }
            }
        }

        for (int k = 0; k < birthCount; k++) {
            boolean placed = false;
            int tries = 0;
            while (!placed && tries < river.length) {
                int idx = random.nextInt(river.length);
                if (next[idx] == null) {
                    next[idx] = (births[k] == 'B') ? new Bear() : new Fish();
                    placed = true;
                }
                tries++;
            }
        }

        river = next;
    }

    private int randomMove() {
        int r = random.nextInt(3);
        return (r == 0) ? -1 : (r == 1 ? 0 : 1);
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20); // Create a river of size 20
        eco.populate(5, 7);
        eco.visualize();
        for (int t = 0; t < 15; t++) {
            eco.runStep();
            eco.visualize();
        }
    }
}

