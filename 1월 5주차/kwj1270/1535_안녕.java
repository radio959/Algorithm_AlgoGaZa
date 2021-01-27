import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int n;   /// 사람의 수
    private static int[] healthMinus; // 체력 잃는 수
    private static int[] pleasurePlus; // 기쁨 얻는 수

    public static void main(String[] args) {
        n = SCANNER.nextInt();
        healthMinus = new int[n];
        pleasurePlus = new int[n];
        d = new int[n][101];

        for (int i = 0; i < n; i++) {
            healthMinus[i] = SCANNER.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pleasurePlus[i] = SCANNER.nextInt();
        }
        System.out.println(go(0, 0, 0));
    }

    public static int go(int index, int now_life, int sum){
        if(now_life >= 100) {
            return 0;
        }
        if(index == n) {
            return sum;
        }
        int answer = 0;

        answer = Math.max(answer, go(index+1,
                now_life+healthMinus[index], sum+pleasurePlus[index]));

        answer = Math.max(answer, go(index+1,
                now_life, sum));

        return answer;
    }
}

