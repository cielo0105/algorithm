import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[] col;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N+1];
		setQueen(1);
		System.out.println(ans);
	}
	
	public static void setQueen(int row) {
		if(!isAvailable(row-1)) return;
		if(row > N) {
			ans++;
			return;
		}
		for(int i=1; i<=N; i++) {
			col[row] = i;
			setQueen(row+1);
		}
	}
	public static boolean isAvailable(int row) {
		for(int i=1; i<row; i++) {
			if(col[i]==col[row] || row-i==Math.abs(col[row]-col[i])) {
				return false;
			}
		}
		return true;
	}
}