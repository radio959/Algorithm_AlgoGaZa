import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 일직선 위애 N개의 높이가 다른 탑
// 각 탑의 꼭대기에 레이저 송신기
// 레이저 완쪽으로 발사
// 탑에는 모두 수신기도 있다.
// 하나의 탑에서 보내면 가장 먼저 받음
public class Main {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static int[] answerArr;
    private static int n;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(BUFFERED_READER.readLine().trim());
        answerArr = new int[n];
        Stack<int[]> stack = new Stack<>();
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
        for(int i=1; i <= n; i++){
            int height = Integer.parseInt(stringTokenizer.nextToken());
            int[] map = new int[2];
            map [0] = i;
            map [1] = height;
            int answer = 0;
            while (!stack.empty()){
                if(stack.peek()[1] >= height){
                    answer = stack.peek()[0];
                    break;
                }
                stack.pop();
            }
            answerArr[i-1] = answer;
            stack.push(map);
        }
        for(int a : answerArr){
            System.out.print(a+" ");
        }
    }
}
