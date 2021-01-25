import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int[] dollar = {7,5,2,1};   /// 사람의 수
    private static int money;   /// 사람의 수
    private static int d[];

    public static void main(String[] args) {
        money = SCANNER.nextInt();
        d = new int[money+1];
        System.out.println(go(money, 0));
    }

    public static int go(int now, int count) {
        if(now == 0){
            return count;
        }
        if(now <= 0){
            return Integer.MAX_VALUE;
        }
        if(d[now] != 0) return d[now];
        d[now] = Integer.MAX_VALUE;
        for(int i=0; i < 4; i++){
            d[now] = Math.min(d[now], go(now-dollar[i], count+1));
        }
        return d[now];
    }
}
