import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] time = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(time,(o1,o2) -> o1[1]==o2[1]? o1[0]-o2[0]:o1[1]-o2[1]);
		int cnt = 1;
		int end = time[0][1];
		for (int i = 1; i < n; i++) {
			if(time[i][0]>=end) {
				end = time[i][1];
				cnt ++;
			}
		}
		System.out.println(cnt);
	}
}
