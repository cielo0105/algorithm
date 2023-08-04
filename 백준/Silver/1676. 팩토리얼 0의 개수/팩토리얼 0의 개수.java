import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
/**

@author 임현지
@since 2023. 8. 4.
@note 
*
* queue
*
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=5; i<=N; i+=5) {
			answer += check(i);
			
		}
		System.out.println(answer);
	
	}
	static int check(int i) {
		int cnt = 0;
		while(i>=5) {
			if(i%5!=0) break;
			i/=5;
			cnt++;
		}
		return cnt;
	}
}