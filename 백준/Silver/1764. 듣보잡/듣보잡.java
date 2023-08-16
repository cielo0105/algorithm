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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Integer> map = new HashMap<>();
		List<String> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 1);
		}
		String name;
		for(int i=0; i<M; i++) {
			name = br.readLine();
			if(map.get(name)!=null) {
				list.add(name);
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(String s:list) {
			System.out.println(s);
		}
	}
}