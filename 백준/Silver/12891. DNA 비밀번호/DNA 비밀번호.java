import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**

@author 임현지
@since 2023. 8. 3.

@note 
* 문자열 길이 S, 부분문자열길이 P
* 문자열
* A C G T 필수 개수
*
*/

public class Main {
	static Map<Character, Integer> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		char[] DNA = br.readLine().toCharArray();
		char[] dna = {'A','C','G','T'};
		map = new HashMap<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++) {
			map.put(dna[i], 0);
		}
		for(int i=0; i<4; i++) {
			map.put(dna[i], Integer.parseInt(st.nextToken())); // 필요한 개수 저장
		}
		int start = 0;
		int end = P-1;
		int answer = 0;
		
		for(int i=start; i<=end; i++) {
			int cnt = map.get(DNA[i]);
			map.put(DNA[i], cnt-1);
		}
		if(check()) answer++;
		try {
		while(end < S) {
			int removeDna = map.get(DNA[start]);
			map.put(DNA[start], removeDna+1);
			end += 1;
			int addDna = map.get(DNA[end]); // 추가해야 될 DNA 개수
			map.put(DNA[end], addDna-1);
			if(check()) {
				answer++;
			}
			start += 1;
			
		}
		
		}catch(ArrayIndexOutOfBoundsException e){
			
		}
		System.out.println(answer);
	}
	static boolean check() {
		for(int val: map.values()) {
			if(val>0) return false;
		}
		return true;
	}
}