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
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new ArrayDeque<>();
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		sb.append("<");
		while(!queue.isEmpty()) {
			for(int i=0; i<K-1; i++) {
				queue.add(queue.poll());
			}
			sb.append(queue.poll()).append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append(">");
		System.out.println(sb);
	}
	
}