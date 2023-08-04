import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/**

@author 임현지
@since 2023. 8. 4.
@note */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++) {
			Stack<Character> stack = new Stack<>();
			String input = br.readLine();
			int flag = 0; // 1이면 vps 아님
			for(int j=0; j<input.length(); j++) {
				char c = input.charAt(j);
				if(c == '(') {
					stack.add(c);
				}
				else if(c == ')') {
					if(!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					}
					else {
						flag = 1;
						break;
					}
				}
			}
			if(stack.isEmpty() && flag == 0) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb);
	}
}