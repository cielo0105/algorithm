import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cnt = n/5;
		int sugar = n%5;
		int flag = 0;
		while(true) {
			if(sugar%3 == 0) {
				cnt += sugar/3;
				break;
			}
			else {
				if(cnt == 0) {
					flag = 1;
					break;
				}
				cnt --;
				sugar += 5;
				
			}
		}
		if(flag == 1) System.out.println(-1);
		else System.out.println(cnt);
	}
}
