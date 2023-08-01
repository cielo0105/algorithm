import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		long sum = 0;
		int[] len = new int[k];
		for(int i=0; i<k; i++) {
			len[i] = Integer.parseInt(br.readLine());
			sum += len[i];
		}
		long end = sum/n;
		long start = 1;
		long max = 0;
		while(start<=end) {
			long mid = (end+start)/2;
			int cnt = 0;
			for(int l:len) {
				cnt += l/mid;
			}
			if(cnt >= n) {
				max = mid;
				start = mid+1;
			}
			else {
				end = mid-1;
			}
		}
		System.out.println(end);
	}

}