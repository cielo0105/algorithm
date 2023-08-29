import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N  = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] input = new int[N];
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		// 테이블 정의 dp[i] : i번째 칸으로 올 수 있는 최소 횟수
		int[] dp = new int[N];
		// 점화식 정의  이거는 안돼 머릿속에서 해결해
		// 초기값 설정
		Arrays.fill(dp, 1001);
		dp[0] = 0;
		for(int i=0; i<N-1; i++) {
			for(int j=1; j<=input[i]; j++) {
				if(i+j >= N) {
					break;
				}
				
				dp[i+j] = Math.min(dp[i] + 1, dp[i+j]);
			}
		}
		if(dp[N-1]==1001) System.out.println(-1);
		else System.out.println(dp[N-1]);
	}
}