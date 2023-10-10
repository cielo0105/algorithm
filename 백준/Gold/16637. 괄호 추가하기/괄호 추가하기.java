import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N;
	static int[] num;
	static char[] op;
	static int answer = Integer.MIN_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N/2+1];
		op = new char[N/2];
		String input = br.readLine();
		for(int i=0; i<N; i++) { 
			char c = input.charAt(i);
			if(i%2 == 0) num[i/2] = c - '0'; // 숫자는 num 배열에 저장
			else op[i/2] = c; // 연산자는 op 배열에 저장
		}
		 dfs(0,num[0]);
		 System.out.println(answer);
	}
	
	static void dfs(int op_i, int before) {
		if(op_i == N/2) {
			answer = Math.max(before, answer);
			return;
		}
		int no_bracket = calc(before,num[op_i+1],op[op_i]); // 괄호 추가 안함
		dfs(op_i+1,no_bracket);
		if(op_i+2 <= N/2) { 
			int bracket = calc(num[op_i+1],num[op_i+2],op[op_i+1]); // 괄호 친 부분 결과
			int next = calc(before,bracket,op[op_i]); // 이전 값과 괄호 친 부분 값 더한 결과
			dfs(op_i+2,next);
		}
	}
	
	static int calc(int fir, int sec, char op) {
		if(op == '+') return fir + sec;
		if(op == '-') return fir - sec;
		if(op == '*') return fir * sec;
		return 0;
	}
}