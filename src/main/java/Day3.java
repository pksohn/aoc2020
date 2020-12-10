import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> map = new ArrayList<>();
        while (scanner.hasNext()) {
            map.add(scanner.nextLine());
        }

        long treeProduct = 1;
        int[][] slopes = {{1, 1}, {1, 3}, {1, 5}, {1, 7}, {2, 1}};

        for (int[] slope : slopes) {
            int x = 0;
            int y = 0;
            int trees = 0;
            int down = slope[0];
            int right = slope[1];

            while (x < map.size()) {
                String line = map.get(x);
                if (line.charAt(y % line.length()) == '#') {
                    trees++;
                }
                x += down;
                y += right;
            }

            treeProduct *= trees;

            // Part 1
            if (down == 1 && right == 3) {
                System.out.println("Part 1 Solution: " + trees);
            }
        }
        System.out.println("Part 2 Solution: " + treeProduct);
    }
}
