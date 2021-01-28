package algorithm_study;

import java.util.Scanner;

public class Hello_1535 {

	static int[] L;  // 안녕하면 잃게 되는 체력
	static int[] J; // 안녕하면 얻게 되는 기쁨
	
	public int max_joy(int i) {
		int max = 0;
		int sum =0;
		for(int j=0; j<i; j++) { //해당 번호까지 행복의 합 구하기
			sum=sum+J[i];
		}
		// 행복의 합이 최댓값인지 비교
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt(); // 사람 수 
		L = new int[N];
		J = new int[N];
		
		for(int i=0; i<N; i++) {
			L[i] = sc.nextInt();
			J[i] = sc.nextInt();
		}
		int hp=0;
		int joy=0;
		for(int i=0; i<N; i++) {
			hp=hp+L[i]; //Array를 돌면서 hp를 더한다.
			joy=joy+J[i]; // Joy를 더한다.
			if(hp>99) { // 더하다가 hp가 100을 넘어버리면
				hp=hp-L[i]; // 마지막 값을 빼준다.
				int temp = joy-J[i]; // temp에다가 마지막 값을 제외한 joy를 대입한다.
				hp=hp-L[i-1]+L[i]; // i-1을 빼주고 i번째를 더하고
				if(hp>100) {// 그래도 100을 넘어가면
					continue;				
				}else { // 100 안넘어가면
					temp=temp+J[i]; // i번째 joy를 넣어준다.
				}
			
			}
		
		}
		

	}
}
