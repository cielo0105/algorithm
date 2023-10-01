import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			if(command.equals("all")) {
				answer = (1<<21) -1; // 전부 1로 채우기
			} 
			else if(command.equals("empty")) {
				answer = 0; // 전부 0으로 표시
			}
			else {
				int num = Integer.parseInt(st.nextToken());
				if(command.equals("add")) {
					answer |= (1<<num);
				}
				else if(command.equals("check")) { // 있으면 1 없으면 0
					int res = answer & (1<<num);
					if(res == 0) sb.append(0+"\n");
					else sb.append(1+"\n");
				}
				else if(command.equals("remove")) {
					answer &= ~(1<<num);
				}
				else if(command.equals("toggle")) {
					answer ^= (1<<num);
				}
				
			}
		}
		System.out.println(sb);
	}
}