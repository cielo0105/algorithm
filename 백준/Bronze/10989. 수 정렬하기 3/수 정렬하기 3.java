import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**

@author 임현지
@since 2023. 8. 4.
@note 
*
*counting sort
*10000보다 작은 자연수 -> 배열 만들어서 나오는 횟수 세어줌
*1부터 차례대로 cnt만큼 출력을 해준다

*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] cnt = new int[10001];
		for(int i=0; i<N; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}
		for(int i=1; i<=10000; i++) {
			if(cnt[i]==0) continue;
			while(cnt[i]>0) {
				sb.append(i).append("\n");
				cnt[i]--;
			}
		}
		System.out.println(sb);
	}

}