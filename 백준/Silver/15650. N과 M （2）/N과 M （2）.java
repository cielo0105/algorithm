import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static int[] choosed;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		choosed = new int[m];
		combination(0,1);
	}
	
	static void combination(int depth,int start) {
		if(depth==m) {
			for(int i:choosed) {
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<=n; i++) {
			choosed[depth] = i;
			combination(depth+1,i+1);
		}
	}

}