import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
/**

@author 임현지
@since 2023. 8. 4.
@note 
*
*push_front
*push_back
*pop_front
*pop_back
*size 스택에 들어있는 정수 개수
*empty 비어있으면 1 아니면 0
*front 가장 앞
*back 가장 뒤
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("push_back")) {
				int num = Integer.parseInt(st.nextToken());
				deque.addLast(num);
			}
			else if(command.equals("push_front")) {
				int num = Integer.parseInt(st.nextToken());
				deque.addFirst(num);
			}
			else {
				if(command.equals("pop_front")) {
					if(!deque.isEmpty()) sb.append(deque.pollFirst()).append("\n");
					else sb.append("-1\n");
				}
				if(command.equals("pop_back")) {
					if(!deque.isEmpty()) sb.append(deque.pollLast()).append("\n");
					else sb.append("-1\n");
				}
				else if(command.equals("size")) {
					sb.append(deque.size()).append("\n");
				}
				else if(command.equals("empty")) {
					if(deque.isEmpty()) sb.append("1\n");
					else sb.append("0\n");
				}
				else if(command.equals("front")) {
					if(deque.isEmpty()) sb.append("-1\n");
					else sb.append(deque.peekFirst()).append("\n");
				}
				else if(command.equals("back")) {
					if(deque.isEmpty()) sb.append("-1\n");
					else sb.append(deque.peekLast()).append("\n");
				}
			}
		}
		System.out.println(sb);
	}

}