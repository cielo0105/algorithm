import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int f = sc.nextInt();
			System.out.println(find(f));
		}
	}
	public static int find(int num) {
		int start = 0;
		int end = n-1;
		
		while(start<=end) {
			int mid = (start + end)/2;
			if(arr[mid] == num) {
				return 1;
			}
			else if(arr[mid]>num) {
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		return 0;
	}
}
