public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> numbers = new DynamicArray<>();

        numbers.add(5);
        numbers.add(10);
        numbers.add(15);
        System.out.println("Numbers: " + numbers);

        System.out.println("First number: " + numbers.get(0));

        numbers.remove(1);
        System.out.println("After removing index 1: " + numbers);

        DynamicArray<String> words = new DynamicArray<>();
        words.add("Hello");
        words.add("World");
        System.out.println("Words: " + words);
    }
}
