import java.util.HashSet;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<Integer>();
        while (scanner.hasNext()) {
            String currentLine = scanner.nextLine();
            int number = Integer.parseInt(currentLine);
            int complement = 2020 - number;
            if (set.contains(complement)) {
                System.out.println("Solution: " + number * complement);
                break;
            } else {
                set.add(number);
            }
        }
    }
}
