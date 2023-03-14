import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static boolean[] visited;
	private static int n,ans,flag;
	private static char[] word;
	private static char[] arr;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		while((input=br.readLine())!=null ) {
			StringTokenizer st = new StringTokenizer(input);
			if(!st.hasMoreTokens()) break;
			word = st.nextToken().toCharArray();
			n = Integer.parseInt(st.nextToken());
			visited = new boolean[word.length];
			ans = 0;
			flag = 0;
			arr = new char[word.length];
			permutation(0);
			if(flag == 0) {
				System.out.print(word);
				System.out.print(" "+ n+" = ");
				System.out.println("No permutation");
			}
		}	
	}
	
	static void permutation(int cnt) {
		if(cnt == word.length) {
			ans++;
			if(ans == n) {
				flag = 1;
				System.out.print(word);
				System.out.print(" "+ n+" = ");
				System.out.println(arr);
			}
		}
		for (int i = 0; i < word.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				arr[cnt] = word[i];
				permutation(cnt+1);
				visited[i] = false;
			}
		}
	}
}

