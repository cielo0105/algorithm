import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main {
	static int[] number;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		number = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(number);
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			if(find(Integer.parseInt(st.nextToken()))) {
				System.out.println(1);
			}
			else System.out.println(0);
		}
	
			
		
	}
	static boolean find(int n) {
		int s = 0;
		int e = number.length-1;
		while(s<=e) {
			int mid = (s+e)/2;
			if(number[mid] == n) return true;
			if(number[mid] > n) {
				e = mid-1;
			}
			else if(number[mid] < n) {
				s = mid+1;
			}
		}
		return false;
	}
}