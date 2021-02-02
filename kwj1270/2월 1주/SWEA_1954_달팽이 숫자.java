import java.util.Scanner;


class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int test;
    private static int n;
    private static int[][] map;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        test = SCANNER.nextInt();
        for (int t = 1; t <= test; t++) {
            n = SCANNER.nextInt();
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    map[i][j] = -1;
                }
            }
            int x = 0;
            int y = 0;
            map[0][0] = 1;
            while (map[x][y] != n * n) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || map[nx][ny] != -1) continue;
                    while (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] == -1){
                        map[nx][ny] = map[x][y]+1;
                        x = nx;
                        y = ny;
                        nx = nx+dx[i];
                        ny = ny+dy[i];
                    }
                }
            }


            System.out.println("#" + t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }


        }
    }

}

// 1 2 3
// 8 9 4
// 7 6 5

// i 123
// j 123

// j%n == 0 -> 기본
