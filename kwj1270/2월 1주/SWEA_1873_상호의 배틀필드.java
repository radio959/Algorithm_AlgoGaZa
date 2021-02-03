import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
 
 
class Solution {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer STRING_TOKENIZER;
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static int test;
    private static int dir;
    private static int x;
    private static int y;
    private static int tank_x;
    private static int tank_y;
    private static int potan_x;
    private static int potan_y;
    private static char[][] map;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static char[] tankDir = {'>', 'v', '<', '^'};
 
    public static void main(String[] args) throws IOException {
        test = Integer.parseInt(BUFFERED_READER.readLine());
        for (int t = 1; t <= test; t++) {
            STRING_TOKENIZER = new StringTokenizer(BUFFERED_READER.readLine());
 
            x = Integer.parseInt(STRING_TOKENIZER.nextToken());
            y = Integer.parseInt(STRING_TOKENIZER.nextToken());
 
            map = new char[x][y];
 
            for (int i = 0; i < x; i++) {
                map[i] = BUFFERED_READER.readLine().toCharArray();
            }
 
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if (map[i][j] == '<' || map[i][j] == '>' || map[i][j] == '^' || map[i][j] == 'v') {
                        if (map[i][j] == '>') dir = 0;
                        if (map[i][j] == 'v') dir = 1;
                        if (map[i][j] == '<') dir = 2;
                        if (map[i][j] == '^') dir = 3;
                        tank_x = i;
                        tank_y = j;
                        break;
                    }
                }
            }
            int input = Integer.parseInt(BUFFERED_READER.readLine());
            char commands[] = BUFFERED_READER.readLine().toCharArray();
 
            for (int i = 0; i < commands.length; i++) {
                run(commands[i]);
            }
 
            System.out.print("#" + t + " " + print());
        }
    }
 
    public static void run(char command) {
        if (command == 'R' || command == 'D' || command == 'L' || command == 'U') {
            if (command == 'R') dir = 0;
            if (command == 'D') dir = 1;
            if (command == 'L') dir = 2;
            if (command == 'U') dir = 3;
 
            map[tank_x][tank_y] = tankDir[dir]; // 방향 변경
 
            int nx = tank_x + dx[dir];          // 다음 이동할 곳
            int ny = tank_y + dy[dir];          // 다음 이동할 곳
 
            if (nx < 0 || nx >= x || ny < 0 || ny >= y) return; // 벗어날 경우 가만히.
            if (map[nx][ny] != '.') return;
 
            map[nx][ny] = tankDir[dir];
            map[tank_x][tank_y] = '.';
            tank_x = nx;
            tank_y = ny;
            return;
        }
        if (command != 'S') return;
 
        potan_x = tank_x;   // 포탄 위치
        potan_y = tank_y;   // 포탄 위치
 
        while (true) {
            int nx = potan_x + dx[dir];
            int ny = potan_y + dy[dir];
            if (nx < 0 || nx >= x || ny < 0 || ny >= y) break;
            if (map[nx][ny] == '#') break;
            if (map[nx][ny] == '*') {
                map[nx][ny] = '.';
                break;
            }
            potan_x = nx;
            potan_y = ny;
        }
    }
 
    public static String print() {
        STRING_BUILDER.setLength(0);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                STRING_BUILDER.append(map[i][j]);
            }
            STRING_BUILDER.append("\n");
        }
        return STRING_BUILDER.toString();
    }
 
}
