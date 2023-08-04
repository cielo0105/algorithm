import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
/**

@author 임현지
@since 2023. 8. 4.
\
@note

 * 나이순 정렬
 * 나이 같으면 먼저 가입한 사람
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		Person[] person = new Person[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			person[i] = new Person(age,name);
		}
		Arrays.sort(person,(a,b)->a.age-b.age);
		for(Person p:person) {
			System.out.println(p);
		}
	}
	
	public static class Person{
		int age;
		String name;
		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		@Override
			public String toString() {
				return this.age + " " + this.name;
			}
	}
}