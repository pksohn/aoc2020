import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {

        int goodPasswords = 0;
        int goodPasswords2 = 0;

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            // Parse line
            String currentLine = scanner.nextLine();
            String[] parts = currentLine.split(":");
            String[] rule = parts[0].split(" ");
            String bounds = rule[0];
            int lowerBound = Integer.parseInt(bounds.split("-")[0]);
            int upperBound = Integer.parseInt(bounds.split("-")[1]);
            char letter = rule[1].charAt(0);
            String password = parts[1].trim();

            // Part 1
            int count = 0;
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == letter) {
                    count++;
                }
            }
            if (count >= lowerBound && count <= upperBound) {
                goodPasswords++;
            }

            // Part 2
            int location1 = lowerBound - 1;
            int location2 = upperBound - 1;
            int sum = 0;
            for (int i : new int[]{location1, location2}) {
                if (password.charAt(i) == letter) {
                    sum++;
                }
            }
            if (sum == 1) {
                goodPasswords2++;
            }
        }

        System.out.println("Part 1 Solution: " + goodPasswords);
        System.out.println("Part 2 Solution: " + goodPasswords2);
    }
}
