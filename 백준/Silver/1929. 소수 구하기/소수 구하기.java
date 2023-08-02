import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
 * 1676
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] prime = new int[n+1]; // 소수 아니면 1로 변경
		prime[1] = 1;
		for(int i=2; i<=n/2;i++) {
			if(prime[i]==1) continue;
			for(int j=2*i; j<=n; j+=i) {
				prime[j] = 1;
			}
		}
		for(int i=m; i<=n; i++) {
			if(prime[i]==0) System.out.println(i);
		}
	}
	
	
}