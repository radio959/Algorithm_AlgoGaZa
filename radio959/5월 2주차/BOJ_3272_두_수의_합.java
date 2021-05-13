package week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3272_두_수의_합 {

	static int n,x;
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cnt=0;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0 ;i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		x = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		for(int i=0 ;i<=n/2+1; i++) {
			int xleft = x-arr[i];
			if(binarySearch(xleft)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	private static boolean binarySearch(int target) {
		
		int start =0;
		int end = arr.length-1;
		int mid = (start+end)/2;
		
		while(end-start>=0) {
			if(arr[mid]==target) {
				return true;
			}else if(arr[mid]>target) {
				end = mid-1;
			}else if (arr[mid]<target) {
				start= mid+1;
			}
			mid = (start+end)/2;
		}
		
		return false;
	}

}
