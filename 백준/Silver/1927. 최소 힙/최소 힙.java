import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
/**

@author 임현지
@since 2023. 8. 4.
@note 
* 리모컨
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int input,out;
		for(int i=0; i<N; i++) {
			input = Integer.parseInt(br.readLine());
			if(input == 0) {
				if(pq.isEmpty()) sb.append(0).append("\n");
				else {
					sb.append(pq.poll()).append("\n");
				}
			}
			else {
				pq.add(input);
			}
		}
		System.out.println(sb);
	
	}
	
}