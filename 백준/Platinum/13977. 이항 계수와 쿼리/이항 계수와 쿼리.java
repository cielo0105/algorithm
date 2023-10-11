import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {
	static int N,K;
	static long MOD = 1000000007;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		long[] fac = new long[40000001];
		fac[0] = 1;
		for(int i=1; i<=40000000; i++) {
			fac[i] = (fac[i-1]*i) % MOD;
		}
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			long ans = (fac[N]%MOD * pow((fac[N-K]*fac[K])%MOD,MOD-2)%MOD)%MOD;
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
	
	static long pow(long bottom, long top) {
		if(top==0) return 1;
		long res = pow(bottom,top/2);
		if(top%2==0) return (res*res)%MOD;
		else return ((res*res)%MOD*bottom)%MOD;
	}
}