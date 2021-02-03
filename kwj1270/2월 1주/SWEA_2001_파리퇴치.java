import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 
class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer STRING_TOKENIZER;
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static int n;
    private static int m;
    private static int test;
    private static int[][] map;
 
    public static void main(String[] args) throws IOException {
        test = SCANNER.nextInt();
        for (int t = 1; t <= test; t++) {
            int answer = 0;
            n = SCANNER.nextInt();
            m = SCANNER.nextInt();
 
            map = new int[n][n];
            for(int i=0; i < n; i++){
                for(int j=0; j < n; j++){
                    map[i][j] = SCANNER.nextInt();
                }
            }
            for (int i=0; i <= n-m; i++){
                for (int j=0; j <= n-m; j++){
                    answer = Math.max(answer, go(i,j));
                }
            }
 
            System.out.println("#"+t+" "+answer);
        }
    }
 
    public static int go(int x, int y){
        int sum = 0;
        for(int i=x; i < x+m; i++){
            for(int j=y; j < y+m; j++){
                sum += map[i][j];
            }
        }
        return sum;
    }
 
 
}
