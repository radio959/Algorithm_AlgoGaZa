import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static final Scanner SCANNER = new Scanner(System.in);
    public static int n;
    public static int person;
    public static int gender;
    public static int swtch;
    public static ArrayList<Boolean> arr;
    public static void main(String[] args) {
        n = SCANNER.nextInt();
        arr = new ArrayList<>();
        arr.add(false);
        for(int i=0; i < n; i++){
            boolean bool = SCANNER.nextInt() == 1 ? true : false;
            arr.add(bool);
        }
        person = SCANNER.nextInt();
        for(int i=0; i < person; i++){
            gender = SCANNER.nextInt();
            swtch = SCANNER.nextInt();
            if(gender == 1){
                men(swtch, 1);
                continue;
            }
            arr.set(swtch, !(arr.get(swtch)));
            women(swtch-1, swtch+1);
        }
        arr.remove(0);
        print();
    }
    public static void men(int now, int depth) {
        if(now > n){
            return;
        }
        arr.set(now, !(arr.get(now)));
        men(swtch*(depth+1), depth+1);
    }
    public static void women(int left, int right) {
        if(left < 1 || right > n || left == right) return;
        if(arr.get(left) != arr.get(right))return;
        arr.set(left, !(arr.get(left)));
        arr.set(right, !(arr.get(right)));
        women(left-1, right+1);
    }
    public static void print(){
        for(int index = 1; index <= arr.size(); index++){
            boolean answer = arr.get(index-1);
            System.out.print( answer ? "1 " : "0 ");
            if (index % 20 == 0) {
                System.out.println();
            }
        }
    }
}
