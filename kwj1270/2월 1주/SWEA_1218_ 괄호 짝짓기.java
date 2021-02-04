// 백준 균형잡힌 세상이랑 문제 동일함 

import java.util.Scanner;
import java.util.Stack;
 
public class Solution {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static int test;
    private static int n;
    private static Stack<Character>[] stacks;
 
    public static void main(String[] args) {
        test = 10;
        for (int t = 1; t <= test; t++) {
            n = SCANNER.nextInt();
            stacks = new Stack[4];
            for(int i=0; i < 4; i++) {
                stacks[i] = new Stack<Character>();
            }
            char[] strs = SCANNER.next().toCharArray();
            for(int i=0; i < strs.length; i++) {
                    if(strs[i] == '(') {stacks[0].add('(');}
                    else if(strs[i] == '[') {stacks[1].add('[');}
                    else if(strs[i] == '{') {stacks[2].add('{');}
                    else if(strs[i] == '<') {stacks[3].add('<');}
                    else if(strs[i] == ')' && !(stacks[0].isEmpty()) && stacks[0].peek() == '(') {stacks[0].pop();}
                    else if(strs[i] == ']' && !(stacks[1].isEmpty()) && stacks[1].peek() == '[') {stacks[1].pop();}
                    else if(strs[i] == '}' && !(stacks[2].isEmpty()) && stacks[2].peek() == '{') {stacks[2].pop();}
                    else if(strs[i] == '>' && !(stacks[3].isEmpty()) && stacks[3].peek() == '<') {stacks[3].pop();}
                    else {stacks[0].push('-'); break;}
            }
             
            boolean flag = true;
            for(int i=0; i < 4; i++) {
                if(!(stacks[i].isEmpty())) {
                    System.out.println("#"+t+" "+0);
                    flag = false;
                    break;
                }
            }
             
            if(flag)System.out.println("#"+t+" "+1);
 
        }
    }
 
}
