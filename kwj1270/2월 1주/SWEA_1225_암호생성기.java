import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static final int TESTCASE = 10;
	public static String trash;
	public static Queue<Integer> q;
	public static StringTokenizer stringTokenizer;
	public static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		for (int t = 1; t <= TESTCASE; t++) {
			trash = BUFFERED_READER.readLine().trim();
			q = new LinkedList<Integer>();
			stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(stringTokenizer.nextToken()));
			}
			int minus = 1;
			while (true) {
				if ((q.peek() - minus) <= 0) {
					q.poll();
					q.offer(0);
					break;
				}
				q.offer(q.poll() - minus);
				minus++;
				if (minus > 5)
					minus = 1;
			}
			System.out.print("#" + t + " ");
			q.stream().forEach((i) -> System.out.print(i + " "));
			System.out.println();
		}
	}
}
