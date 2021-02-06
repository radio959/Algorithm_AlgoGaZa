import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer STRING_TOKENIZER;
    private static int n;
    private static int test;
    private static Queue<String> q;
    private static Queue<String> q2;

    public static void main(String[] args) throws IOException {
        test = Integer.parseInt(BUFFERED_READER.readLine().trim());
        for (int t = 1; t <= test; t++) {
            STRING_BUILDER.setLength(0);
            STRING_BUILDER.append("#").append(t).append(" ");
            n = Integer.parseInt(BUFFERED_READER.readLine().trim());
            q = new LinkedList<>();
            q2 = new LinkedList<>();
            STRING_TOKENIZER = new StringTokenizer(BUFFERED_READER.readLine(), " ");

            int mid = n % 2 == 0 ? n / 2 : (n / 2) + 1;
            for (int i = 0; i < mid; i++) {
                q.add(STRING_TOKENIZER.nextToken());
            }
            for (int i = mid; i < n; i++) {
                q2.add(STRING_TOKENIZER.nextToken());
            }

            while (true) {
                if (q.isEmpty() && q2.isEmpty()) break;
                if (!q.isEmpty()) {
                    STRING_BUILDER.append(q.poll()).append(" ");
                }
                if (!q2.isEmpty()) {
                    STRING_BUILDER.append(q2.poll()).append(" ");
                }
            }
            STRING_BUILDER.setLength(STRING_BUILDER.length() - 1);
            System.out.println(STRING_BUILDER.toString());
        }
    }


}
