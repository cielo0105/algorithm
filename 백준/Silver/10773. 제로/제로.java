import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
/**

@author 임현지
@since 2023. 8. 4.
@note 

* 10773번
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) stack.pop();
			else stack.push(num);
		}
		int sum = 0;
		for (int i : stack) {
			sum += i;
		}
		System.out.println(sum);
	}
}