import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 전봇대 N개 
 * N번째 - 어떤 전봇대와 연결됐는지
 * 증가하는 수열 중 가장 긴거
 */
public class Main {
	static int N;
	static int[] list,dp;
	static int curr = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new int[N];
		dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = list[0];
		for(int i=1; i<N; i++) {
			if(dp[curr] < list[i]) {
				curr++;
				dp[curr] = list[i];
			}
			else {
				dp[binary(list[i])]=list[i];
			}
		}
		System.out.println(N-(curr+1));
	}
	
	static int binary(int num) {
		int start = 0, mid = 0;
		int end = curr;
		int ans = 0;
		while(start<=end) {
			mid = (start+end)/2;
			if(dp[mid]>num) {
				end = mid-1;
				ans = mid;
			}
			else if(dp[mid]<num) {
				start = mid+1;
			}
		}
		return ans;
	}
}