import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * R*C
 * 오, 오위, 오아래
 * .: 빈칸   x: 건물
 * 왼쪽에서 오른쪽
 * y=0 -> y=C-1
 */
public class Main {
	static int R,C;
	static char graph[][];
	static boolean visited[][];
	static int ans = 0;
	static int flag;
	static int[][] deltas = {{-1,1},{0,1},{1,1}};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		graph = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			graph[i] = br.readLine().toCharArray();
		}
		for(int i=0; i<R; i++) {
				flag = 0;
				find(i,0); // 왼쪽에서 출발
			
		}
		System.out.println(ans);
		
	}
	static void find(int a, int b) {
		if(flag == 1) return;
		if(b==C-1) {
			ans++;
			flag = 1;
			return;
		}
		int nx,ny;
		for(int i=0; i<3; i++) {
			nx = a + deltas[i][0];
			ny = b + deltas[i][1];
			if(nx>=0 && nx<R && ny>=0 && ny<C && graph[nx][ny]!='x' && !visited[nx][ny]) {
				visited[nx][ny] = true;
				find(nx,ny);
				if(flag == 1) break;
//				visited[nx][ny] = false;
			}
		}
	}
}