import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] num, ans;
	static int cnt = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		ans = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		ans[cnt++] = num[0];
		for(int i=1; i<N; i++) {
			if(ans[cnt-1] < num[i]) {
				ans[cnt++] = num[i];
			}
			else {
				int loc = binary(num[i]);
				if(loc==-1) continue;
				ans[loc] = num[i];
			}
		}
		System.out.println(cnt);
	}
	
	static int binary(int n) {
		int start = 0, mid = 0, loc = 0;
		int end = cnt-1;
		while(start<=end) {
			mid = (start+end)/2;
			if(ans[mid]==n) return -1;
			if(ans[mid] < n) {
				start = mid+1;
			}
			else {
				loc = mid;
				end = mid-1;
			}
		}
		return loc;
	}
}