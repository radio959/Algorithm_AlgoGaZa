import java.io.IOException;
import java.util.Scanner;

class Solution {


    public static int[] dx = {-1,0,0};
    public static int[] dy = {0,-1,1};

    public static final Scanner SCANNER = new Scanner(System.in);
    public static boolean[][] map; // 지나온길 -1, 못가는길 0, 가는길 1

    public static void main(String[] args) throws IOException {
        for(int t=1; t <= 10; t++){
            int test = SCANNER.nextInt();
            map = new boolean[100][100];
            int start_x=0, start_y=0;
            for(int i=0; i < 100; i++){
                for(int j=0; j < 100; j++){
                    int temp = SCANNER.nextInt();
                    if(temp == 2) {
                        start_x = i;
                        start_y = j;
                    }
                    map[i][j] = temp == 1 ? true : false;
                }
            }

            while (start_x != 0) {
                for(int i=0; i < 3; i++){
                    int nx = start_x +dx[i];
                    int ny = start_y +dy[i];
                    if(nx < 0 || nx >= 100) continue;
                    if(ny < 0 || ny >= 100) continue;
                    if(map[nx][ny] == false) continue;
                    map[nx][ny] = false;
                    start_x = nx;
                    start_y = ny;
                }
            }
            System.out.println("#"+t+" "+start_y);
        }
    }
}
