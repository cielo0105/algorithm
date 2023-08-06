import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/**

@author 임현지
@since 2023. 8. 4.
@note 
*
* 제일 위에 있는 카드 버리고 그다음 제일 위에 있는 카드 맨 아래로 보냄
* 카드 하나 남을 때까지 반복
* Queue 사용
* poll(), offer() 모두 시간복잡도 O(n)
* 1 ≤ N ≤ 500,000  2초
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		while(queue.size()>1) { // 하나만 남은 경우 빠져나옴
			queue.poll(); // 하나 버리기
			queue.offer(queue.poll()); // 맨 위의 카드 맨 아래로 보내기
		}
		System.out.println(queue.peek()); // 맨 위에 있는 카드 출력
	}
	
}