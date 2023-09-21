import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 계란 내구도 - 상대 계란의 무게만큼 깎임
 * 0 이하가 되는 순간 깨짐
 * 과정
 * 1. 가장 왼쪽의 계란 든다
 * 2. 깨지지 않은 다른 계란 친다. 깨지지 않았으면 제자리에 다시 내려놓는다 (한번만)
 * 3. 다음 계란을 들고 2번 과정 진행. 다음 계란 없는 경우 종료
 * 최대 깰 수 있는 계란 수
 */
public class Main {
	static int N, e, flag;
	static Egg[] eggs;
	static int max = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		eggs = new Egg[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		find(0,0);
		System.out.println(max);
	}
	
	public static void find(int nth, int cnt) {
		if(nth == N) {
			max = Math.max(max, cnt);
			return;
		}
		if(eggs[nth].value <= 0) {
			find(nth+1, cnt);
			return;
		}
		
			for(int i=0; i<N; i++) {
				if(i==nth) continue;
				if(eggs[i].value <= 0) {
					find(nth+1,cnt);
				}
				else {
					e = 0;
					eggs[i].value -= eggs[nth].weight;
					eggs[nth].value -= eggs[i].weight;
					if(eggs[i].value <= 0) e++;
					if(eggs[nth].value <= 0) e++;
					find(nth+1,cnt+e);
					eggs[i].value += eggs[nth].weight;
					eggs[nth].value += eggs[i].weight;
				}
			}
	}
	static class Egg{
		int value, weight;
		public Egg(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}
	}
}