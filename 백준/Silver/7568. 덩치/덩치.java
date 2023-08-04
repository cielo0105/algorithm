import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**

@author 임현지
@since 2023. 8. 4.
@note */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[][] size = new int[N][3];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			size[i][0] = Integer.parseInt(st.nextToken());
			size[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N-1; i++) {
			for(int j=i+1; j<N; j++) {
				if(size[i][0]>size[j][0] && size[i][1]>size[j][1]) {
					size[j][2]++;
				}
				else if(size[i][0]<size[j][0] && size[i][1]<size[j][1]) {
					size[i][2]++;
				}
			}
		}
		for(int[] s:size) {
			sb.append(s[2]+1).append(" ");
		}
		System.out.println(sb);
	}
}