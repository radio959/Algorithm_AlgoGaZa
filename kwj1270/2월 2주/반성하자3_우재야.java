import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
    private static final BufferedReader BUFFERED_READER = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder STRING_BUILDER = new StringBuilder();
    private static StringTokenizer stringTokenizer;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        STRING_BUILDER.setLength(0);
        n = Integer.parseInt(BUFFERED_READER.readLine().trim());
        m = Integer.parseInt(BUFFERED_READER.readLine().trim());

        ArrayList<Integer> arrayList = new ArrayList<>();
        stringTokenizer = new StringTokenizer(BUFFERED_READER.readLine(), " ");
        while (stringTokenizer.hasMoreTokens()){
            arrayList.add(Integer.parseInt(stringTokenizer.nextToken()));
        }

        int result = 0;
        for(int i=0; i <= n; i++){
            int answer = Integer.MAX_VALUE;
            String compare = Integer.toBinaryString(i);
            for(int j=0; j < arrayList.size(); j++){
                int temp  = 0;
                temp = countDiffBit(i, arrayList.get(j));
                answer = Math.min(answer, temp);
            }
            result = Math.max(result, answer);
        }
        System.out.println(result);

    }
    public static int countDiffBit(int i, int j){
        int temp = i ^ j;
        String ttemp = Integer.toBinaryString(temp);
        int answer = 0;
        for(int k=0; k < ttemp.length(); k++){
            if(ttemp.charAt(k) == '1') answer++;
        }
        return answer;
    }

}
 
