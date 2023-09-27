import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 맥주 한 박스 20병
 * 50미터마다 한 병 => 한번에 최대 1000
 * 편의점 - 빈 병 버리고 새 맥주병
 */
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			Point[] location = new Point[N+2];
			int[][] dp = new int[N+2][N+2];
			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine());
				location[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			for(int i=0; i<N+2; i++) {
				for(int j=i+1; j<N+2; j++) {
					if(i==j) dp[i][j] = 0;
					else {
						int dist = Math.abs(location[i].x - location[j].x) + Math.abs(location[i].y - location[j].y); 
						if(dist>1000) {
							dp[i][j] = 1000000000;
							dp[j][i] = 1000000000;
						}
						else {
							dp[i][j] = dist;
							dp[j][i] = dist;
						}
					}
				}
			}
			for(int mid=0; mid<N+2; mid++) {
				for(int i=0; i<N+2; i++) {
					for(int j=0; j<N+2; j++) {
							dp[i][j] = Math.min(dp[i][j], dp[i][mid]+dp[mid][j]);
					}
				}
			}
			if(dp[0][N+1] >= 1000000000) sb.append("sad\n");
			else sb.append("happy\n");
		}
		System.out.println(sb);
	}
}