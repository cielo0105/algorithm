import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		boolean[][] visited = new boolean[101][101];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for(int a=x; a<x+10;a++) {
				for(int b=y; b<y+10; b++) {
					visited[a][b] = true;
				}
			}
		}
		int cnt = 0;
		for(int i=0; i<=100; i++) {
			for(int j=0; j<=100; j++) {
				if(visited[i][j]) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}