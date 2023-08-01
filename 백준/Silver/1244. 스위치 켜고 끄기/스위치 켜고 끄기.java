/**

@author 임현지
@since 2023. 8. 1.
@see
@git
@youtube
@performance
@category #
@note 

* 남학생 - 뽑은 숫자 배수 위치 상태 변경
* 여학생 - 뽑은 숫자 기준으로 양 옆 대칭 이루는 최대에서 변경
* 
*
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static String[] sw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		sw = br.readLine().split(" ");
		int student = Integer.parseInt(br.readLine());
		for (int i = 0; i < student; i++) {
			st = new StringTokenizer(br.readLine());
			String gender = st.nextToken();
			int number = Integer.parseInt(st.nextToken());
			if (gender.equals("1")) { // 남자
				for (int j = number; j - 1 < n; j += number) { // 배수인 경우 스위치 상태 변경
					change(j - 1);
				}
			} else { // 여자
				change(number - 1);
				for (int j = 1; j < n; j++) {
					int front = number - j - 1;
					int back = number + j - 1;
					if (front >= 0 && back < n && sw[front].equals(sw[back])) {
						change(front);
						change(back);
					}

					else
						break;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(sw[i] + " ");
			if (i % 20 == 19)
				System.out.println();
		}
	}

	static void change(int n) {
		if (sw[n].equals("0"))
			sw[n] = "1";
		else
			sw[n] = "0";
	}
}