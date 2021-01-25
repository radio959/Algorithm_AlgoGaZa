import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int n;
    private static int[] boxes;
    private static int[] d;

    public static void main(String[] args) {
        n = SCANNER.nextInt();
        boxes = new int[n];
        d = new int[n];

        for (int i = 0; i < n; i++) {
            boxes[i] = SCANNER.nextInt();
        }

        for(int i=0; i < n; i++){
            d[i] = 1;
            for(int j=0; j < i; j++){
                if(boxes[j] < boxes[i] && d[j]+1 > d[i])
                d[i] = d[j]+1;
            }
        }

        Arrays.sort(d);
        System.out.println(d[n-1]);
    }
}
