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
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		double sum = 0;
		double max = 0;
		int[] grade = new int[n];
		for(int i=0; i<n; i++) {
			grade[i] = Integer.parseInt(st.nextToken());
			max = max>grade[i]?max:grade[i];
		}
		for(int i:grade) {
			sum += i/max *100;
		}
		System.out.println(sum/n);
	}

}