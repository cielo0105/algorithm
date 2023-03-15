
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static int l,c;
	private static String[] arr;
	private static String[] pw;
	private static boolean[] visited;
	private static String[] v = new String[] {"a","e","i","o","u"};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		l = sc.nextInt();
		c = sc.nextInt();
		arr = new String[c];
		pw = new String[l];
		visited = new boolean[c];
		for (int i = 0; i < c; i++) {
			arr[i] = sc.next();
		}
		Arrays.sort(arr);
//		System.out.println(Arrays.asList(v).contains(arr[0]));
		permutation(0,0);
	}
	
	static void permutation(int cnt, int ind) {
		if(cnt == l) {
			int a = 0;
			int b = 0;
			for (String s : pw) {
				if (Arrays.asList(v).contains(s)) a++; // 모음인 경우
				else b++;
			}
			if(a>=1 && b>=2) {
				for (String s : pw) {
					System.out.print(s);
				}
				System.out.println();
			}
			return;
		}
		for (int i = ind; i < c; i++) {
			if(!visited[i]) {
				pw[cnt] = arr[i];
				visited[i] = true;
				permutation(cnt+1,i);
				visited[i] = false;
			}
		}
	}
}
