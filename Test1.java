/*
Test1.java : 자판기
 */

public class Test1 {

	public static void main(String[] args) {
		int a; // 투입금액
		int b; // 상품금액
		int c; // 거스름돈
		int cnt=0; // 카운트
		a=10000;
		b=2530;
		c=7470;
		System.out.println("투입금액 : "+a+"원");
		System.out.println("상품금액 : "+b+"원");
		System.out.println("거스름돈 : "+c+"원");
		
		while(c>=1000) { // 거스름돈이 1000원보다 크면
			c=c-1000;	// 거스름돈에서 1000원씩 뺀다.
			cnt++;		// 빼낸 횟수가 1000원의 장수가 되므로, 이를 카운트하여
		}
		System.out.println("1000원 : "+cnt+"장");		// 천원의 장수로 출력한다.
		cnt=0; // 카운트는 다시 0으로 초기화
		
		while(c>=500) { // 500원보다 클 때도 마찬가지
			c=c-500;
			cnt++;
		}System.out.println("500원 : "+cnt+"개");		
		cnt=0; // 카운트는 다시 0으로 초기화
		
		while(c>=100) { // 100원 보다 클 때도 마찬가지
			c=c-100;
			cnt++;
		}System.out.println("100원 : "+cnt+"개");		
		cnt=0; // 카운트는 다시 0으로 초기화
		
		while(c>=50) { // 50원, 10원도 위와 같이 구현해준다.
			c=c-50;
			cnt++;
		}System.out.println("50원 : "+cnt+"개");		
		cnt=0; // 카운트는 다시 0으로 초기화
		
		while(c>=10) {
			c=c-10;
			cnt++;
		}System.out.println("10원 : "+cnt+"개");		
		cnt=0; // 카운트는 다시 0으로 초기화
		

	}

}