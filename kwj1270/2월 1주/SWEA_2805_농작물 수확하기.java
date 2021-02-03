import java.util.Scanner;
 
class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int test;
    private static int n;
    private static int map[][];
    public static void main(String[] args) {
        test = SCANNER.nextInt();
        for(int t=1; t <= test; t++){
            n= SCANNER.nextInt();
            map = new int[n][n];
            for(int i=0; i < n; i++){
                char[] temp = SCANNER.next().toCharArray();
                for(int j=0; j < n; j++){
                    map[i][j] = temp[j]-'0';
                }
            }
            int x = n/2;
            int answer = 0;
            int start_x = x;
            int range = 0;
            for(int i=0; i <= n/2; i++){
                for(int j=start_x; j <= start_x+range; j++){
                    answer += map[j][i];
                }
                start_x = start_x-1;
                range +=2;
            }
 
            start_x = x;
            range = 0;
            for(int i=n-1; i >= n/2; i--){
                for(int j=start_x; j <= start_x+range; j++){
                    answer += map[j][i];
                }
                start_x = start_x-1;
                range +=2;
            }
            for(int i=0; i < n; i++){
                answer -= map[i][n/2];
            }
            System.out.println("#"+t+" "+answer);
        }
    }
 
}
