import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
/**

@author 임현지
@since 2023. 8. 3.
@note

 * 제일 위에 있는 카드 버림 -> 제일 위에 있는 카드 제일 아래로 보냄
 * 하나 남을때까지 반복
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<=n; i++) {
			queue.add(i);
		}
		while(true) {
			if(queue.size()==1) break;
			queue.remove();
			if(queue.size()==1) break;
			queue.add(queue.poll());
		}
		System.out.println(queue.poll());
	}
}