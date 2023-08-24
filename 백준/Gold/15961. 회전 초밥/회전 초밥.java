import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * N 접시 수
 * d 초밥 가짓수
 * k 연속해서 먹는 접시 수
 * c 쿠폰 번호
 * 
 */
public class Main {
	static int[] sushi;
	static int[] visit;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		sushi = new int[N];
		visit = new int[d+1];
		for(int i=0; i<N; i++) {
			sushi[i] = Integer.parseInt(br.readLine());
		}
		int start = 0; 
		int end = k-1;
		visit[c] = 1; // 쿠폰은 고정으로
		int cnt = 1;
		for(int i=start; i<=end; i++) { // 초기 방문
			if(visit[sushi[i]] == 0) cnt++;
			visit[sushi[i]] += 1;
		}
		max = cnt; 
		for(int i=1; i<N; i++) {
			visit[sushi[start]]-=1;
			if(visit[sushi[start]]== 0) cnt -= 1; // 뺀 게 하나 있었으면 종류-1
			start += 1;
			end = (end+1) % N;
			if(visit[sushi[end]]==0) cnt += 1;
			visit[sushi[end]] += 1;
			max = Math.max(max, cnt);
		}
		System.out.println(max);
	}
	
}