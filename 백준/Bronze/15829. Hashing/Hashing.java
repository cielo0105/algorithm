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
*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		int r = 31;
		int M = 1234567891;
		long sum = 0;
		char[] word = br.readLine().toCharArray();
		for(int i=0; i<L; i++) {
			int ai = ((int)(word[i]-'a')+1);
			
			int ri = 1;
			for(int j=0; j<i; j++) {
				ri = (ri*r)%M;
			}
			sum += (ai*ri)%M;
		}
		System.out.println(sum);
	}
	
}