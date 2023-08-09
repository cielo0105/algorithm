import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**

@author 임현지
@since 2023. 8. 4.

@note 
*
*/

public class Main {
	static Integer[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new Integer[N+1];
		dp[0]=dp[1]=0;
		recursion(N);
		System.out.println(dp[N]);
	}
	static int recursion(int num) {
		if(dp[num]==null) {
			if(num%6==0) 
				dp[num] = Math.min(recursion(num/3),Math.min(recursion(num/2),recursion(num-1))) + 1;
			else if(num%3==0) dp[num] = Math.min(recursion(num/3),recursion(num-1)) + 1;
			else if(num%2==0) dp[num] = Math.min(recursion(num/2),recursion(num-1)) + 1;
			else dp[num] = recursion(num-1) + 1;
		}
		return dp[num];
	}
}