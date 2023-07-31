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
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int cnt = 0;
		int num = 666;
		while(true) {
			if(String.valueOf(num).contains("666")) {
				cnt++;
				if(cnt==n) {
					System.out.println(num);
					break;
				}
				
			}
			num++;
		}
	}
	

}