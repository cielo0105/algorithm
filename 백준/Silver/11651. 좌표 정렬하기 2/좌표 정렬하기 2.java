import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
/**

@author 임현지
@since 2023. 8. 4.
@note 
*
*

*/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Location[] location = new Location[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			location[i] = new Location(x,y);
		}
		Arrays.sort(location,(a,b)->{
			if(a.y == b.y) return a.x-b.x;
			else return a.y-b.y;
		});
		for(Location l: location) {
			sb.append(l.toString()).append("\n");
		}
		System.out.println(sb);
	}
	public static class Location{
		public int x;
		public int y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
			public String toString() {
				return this.x + " "+ this.y;
			}
	}
}