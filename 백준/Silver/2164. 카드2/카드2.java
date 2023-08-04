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
* queue
*
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		while(queue.size()>1) { // 하나만 남은 경우 빠져나옴
			queue.remove(); // 하나 버리기
			queue.add(queue.poll()); // 맨 위의 카드 맨 아래로 보내기
		}
		System.out.println(queue.poll());
	}
	
}