import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
 
class Solution {
 
    public static final Scanner SCANNER = new Scanner(System.in);
    public static int[] arr;
    public static int TESTCASE = 10;
    public static int WIDTH = 100;
 
    public static int n;
 
    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= TESTCASE; t++) {
            int n = SCANNER.nextInt();
            arr = new int[WIDTH];
            for (int i = 0; i < WIDTH; i++) {
                arr[i] = SCANNER.nextInt();
            }
            for (int i = 0; i < n; i++) {
                Arrays.sort(arr);   // 오름 차순
                arr[WIDTH - 1]--;
                arr[0]++;
            }
            Arrays.sort(arr);   // 오름 차순
            System.out.println("#" + t + " " + (arr[WIDTH - 1] - arr[0]));
        }
 
    }
 
}
