import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**

@author 임현지
@since 2023. 8. 9.

@note 
* 1541
* -면 스택 저장 +면 계산해서 스택에 넣음
*/

public class Main {
	static Integer[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] input = br.readLine().split("\\-");
		int answer = getSum(input[0]);
		for(int i=1; i<input.length; i++) {
			answer -= getSum(input[i]);
		}
		System.out.println(answer);
	}
	static int getSum(String s) {
		String[] plus = s.split("\\+");
		int sum = 0;
		for(String num:plus) {
			sum += Integer.parseInt(num);
		}
		return sum;
	}
}