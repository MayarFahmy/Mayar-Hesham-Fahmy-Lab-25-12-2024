import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String> list = new ArrayList<>();

        System.out.println("Enter Values in string array list: ");
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            list.add(input);
        }

        Map<Character, ArrayList<String>> map = new HashMap<>();

        for (String word : list) {
            if (word.isEmpty()) {
                continue;
            }

            char firstChar = Character.toLowerCase(word.charAt(0));
            if (!map.containsKey(firstChar)) {
                map.put(firstChar, new ArrayList<>());
            }
            if (map.get(firstChar).contains(word)) {
                System.out.println("Redundant value detected: " + word);
            } else {
                map.get(firstChar).add(word);
            }
        }


        for (Map.Entry<Character, ArrayList<String>> entry : map.entrySet()) {
            ArrayList<String> words = entry.getValue();
            words.sort((a, b) -> a.compareTo(b));
        }

        System.out.println("Dictionary:");
        for (Map.Entry<Character, ArrayList<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Enter a letter to display its words:");
        char letter = Character.toLowerCase(sc.next().charAt(0));
        if (map.containsKey(letter)) {
            System.out.println("Words for letter '" + letter + "': " + map.get(letter));
        } else {
            System.out.println("No words found for letter '" + letter + "'.");
        }
    }
}
