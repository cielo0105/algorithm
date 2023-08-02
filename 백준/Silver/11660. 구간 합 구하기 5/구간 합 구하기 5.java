/**

@author 임현지
@since 2023. 8. 2.
@see
@git
@youtube
@performance
@category #
@note 
* 2차원 배열 sum에 (0,0)에서 (i,j)까지의 합 저장 
* graph[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1]
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] graph = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] sum = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				sum[i][j] = graph[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
			}
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			/// sum[x2][y2] - sum[x1][y2] - sum[x2][y1] + sum[x1][y1]
		
			System.out.println(sum[x2][y2] - sum[x1][y2] - sum[x2][y1] + sum[x1][y1]);
		}
	}
}