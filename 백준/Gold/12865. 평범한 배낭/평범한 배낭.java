import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Item[] items = new Item[N + 1];
		for(int i=1; i<=N; i++) {	
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			items[i] = new Item(w,v);
		}
		
		
		// 테이블 정의 dp[i][j] : i번째 아이템까지 고려했을 때 jkg 가방에 넣을 수 있는 아이템 가치의 최대 합
		int[][] dp = new int[N+1][K+1];
		for (int i = 0; i <= N; i++)
			dp[i][0] = 0;
		
		// 점화식 정의  
		// j(현재 가방 최대 무게) - w[i] (i번째 아이템 무게) : 남은 공간
		// dp[i - 1][남은공간] + v[i] > dp[i - 1][j] 
		for (int j = 0; j <= K; j++) {
			for (int i = 1; i <= N; i++) {
				int 남은공간 = j - items[i].w;
				if (남은공간 < 0) {
					dp[i][j] = dp[i - 1][j];
					continue;
				}
				
				int val = dp[i-1][남은공간] + items[i].v;
				if (val > dp[i-1][j])
					dp[i][j] = val; 
				else
					dp[i][j] = dp[i - 1][j]; 
			}
		}
		
		System.out.println(dp[N][K]);
	}
	
	static class Item{
		int w,v;
		public Item(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}
}