import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int[] sortNum = Arrays.copyOf(num, N);
		Arrays.sort(sortNum);
		Map<Integer, Integer> map = new HashMap<>();
		int rank = 0;
		for(int i=0; i<N; i++) {
			if(!map.containsKey(sortNum[i])) {
				map.put(sortNum[i], rank++);
				
			}
		}
		for(int i=0; i<N; i++) {
			sb.append(map.get(num[i])+" ");
		}
		System.out.println(sb);
	}
}