import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	static char[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		List<String> list = new ArrayList<>(set);
		list.sort((a,b)->{
			int cmp = a.length()-b.length();
			if(cmp!=0) return cmp;
			return a.compareTo(b);
		}
		);
		for(String s:list) {
			System.out.println(s);
		}
	}
	
}