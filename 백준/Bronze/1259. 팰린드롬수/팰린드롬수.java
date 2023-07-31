import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[] num;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			char[] input = br.readLine().toCharArray();
			if(input.length==1 && input[0] == '0') break;
			int s = 0; 
			int e = input.length-1;
			int flag = 0;
			for(int i=0; i<input.length/2; i++) {
				if(input[s]!=input[e]) {
					flag = 1;
					break;
				}
				s++;
				e--;
			}
			if(flag==0) System.out.println("yes");
			else System.out.println("no");
		}
		
	}
	
}
