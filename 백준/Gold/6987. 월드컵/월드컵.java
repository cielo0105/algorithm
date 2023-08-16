import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {	
	static Country[] country;
	static int answer = 0;
	static int flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int win,lose,draw;
		int w,l,d;
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine());
			win = 0;
			lose = 0;
			draw = 0;
			answer = 1;
			flag = 0;
			country = new Country[6];
			for(int j=0; j<6; j++) {
				w = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				l= Integer.parseInt(st.nextToken());
				country[j] = new Country(j, w, d, l);
	
			}
	
			
			find(0,1);
			if(flag==0) answer = 0;
			
			
			sb.append(answer).append(" ");
		}
		System.out.println(sb);
	}
	static void find(int first, int second) {
		if(first==5 || flag == 1) {
			if(isZero()) {
				flag = 1;
			}
			return;
		}
		if(second==6) {
			find(first+1,first+2);
			return;
		}
		if(country[first].win > 0 && country[second].lose > 0) {
			country[first].win -= 1;
			country[second].lose -= 1;
			find(first, second+1);
			country[first].win += 1;
			country[second].lose += 1;
		}
		if(country[first].lose > 0 && country[second].win > 0) {
			country[first].lose -= 1;
			country[second].win -= 1;
			find(first,second+1);
			country[first].lose += 1;
			country[second].win += 1;
		}
		if(country[first].draw > 0 && country[second].draw > 0) {
			country[first].draw -= 1;
			country[second].draw -= 1;
			find(first,second+1);
			country[first].draw += 1;
			country[second].draw += 1;
		}
	}
	
	static boolean isZero() {
		for(Country c: country) {
			if(c.win != 0 || c.draw != 0 || c.lose != 0) return false;
		}
		return true;
	}
	
	
	public static class Country{
		int win,draw,lose,name;
		public Country(int name,int win, int draw, int lose) {
			this.name = name;
			this.win = win;
			this.draw = draw;
			this.lose = lose;
		}
		@Override
		public String toString() {
			return this.win+" "+this.draw+" "+this.lose;
		}
	}
}