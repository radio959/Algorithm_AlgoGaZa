package com.study14;

/*선수들을 배열로 구성
 * 타순은 큐에 입력
 * 순열을 이용하여 해결
 * 마운드는 배열로 입력 -> 범위를 넘어서면 점수 +1 하는 형식
 * 
  * */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon_17281_baseball {
	static int[][] inning; //이닝당 선수들 활약표
	static int N;//이닝수
	static int cnt;
	static int outcnt;
	static boolean isSelected[] = new boolean[10];
	static int[] numbers= new int[10];
	static int scores;
	static boolean[] base;
	static int startNum=1;
	static int max=0;
	//static Queue<Integer> que = new LinkedList<>();// 선수들을 넣을 배열
	
	static void permutaion(int cnt) {
		if(cnt==10) {
			play();
			return;
		}
		for (int i = 1; i <=9; i++) {
			if(isSelected[i]) {
				continue;
			}
			numbers[i]=cnt;
			isSelected[i] = true;
			
			permutaion(cnt+1);
			isSelected[i]=false;
		}
	}
	static void play() {
		scores=0; // 초기화 잘하자 1시간 날렸다
		startNum=1;
		for (int i = 0; i < N; i++) {
			outcnt=0;
			base= new boolean[4];
			
			while(true) {
				for (int j = startNum; j <= 9; j++) {
					
					int player=inning[i][numbers[j]];
					
					switch(player) 
					{
						case 0:
							outcnt++;
							break;
						case 1:
						case 2:
						case 3:
							for (int k = 3; k >= 1; k--) {
	                            if (base[k]) {
	                                if (k+player>=4) { 
	                                    scores++; 
	                                    base[k] = false; 
	                                    continue;
	                                }
	 
	                                
	                                base[k] = false;
	                                base[k + player] = true;
	                            }
	                        }
	                        base[player] = true;
	                        break;
	                
						case 4:
							for (int k = 1; k <=3; k++) {
								if(base[k])
									scores++;
									base[k]=false;
							}
							scores++;
							break;
					}
					if(outcnt==3) {
					startNum = (j+1); // 수 정확히 생각 하자
					if(startNum ==10) {
						startNum=1;
					}
					break;
					}
					
				}
				if(outcnt==3)
					break;
				
				startNum=1;
			}//와일 바깥
			max = Math.max(max, scores);
		}//이닝 바깥
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inning = new int[51][10];
		for (int i = 0; i <N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
			for (int j = 1; j <=9; j++) {
				inning[i][j]= Integer.parseInt(st.nextToken());
			}
			
		}
		isSelected[4]=true;
		numbers[4]=1;
		scores=0;
		permutaion(2);
		
		System.out.println(max);
		
		
		
	}
}
