import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * @author 임현지
 * @since 2023. 8. 1.
 * @see
 * @git
 * @youtube
 * @performance
 * @category #
 * @note
 * 
 */

public class Main {
	static boolean[] visited;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		int[] number = new int[n];
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(br.readLine());
		}
		int curr = 1;
		String answer = " ";
		for (int i : number) {
			while (true) {
				if (i >= curr) {
					stack.push(curr++);
					sb.append("+");
				} else {
					if (stack.peek() == i) {
						stack.pop();
						sb.append("-");
						break;
					} else {
						sb.setLength(0);
						answer = "NO";
						break;
					}
				}
			}
			if (answer.equals("NO"))
				break;
		}
		if (answer.equals("NO"))
			System.out.println(answer);
		else {
			for (int i = 0; i < sb.length(); i++) {
				System.out.println(sb.charAt(i));
			}
		}
	}

}