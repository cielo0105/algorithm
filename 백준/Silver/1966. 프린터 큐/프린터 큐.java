import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 
 * @author 임현지
 * @since 2023. 8. 1.
 * @see
 * @git
 * @youtube
 * @performance
 * @category #
 * @note
 * 
 * priorityQueue에 중요도 넣어서 최댓값 알아내기
 * 
 * 
 */

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i=0; i<t; i++) {
			Queue<Integer> max = new PriorityQueue<>();
			Queue<Point> queue = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				max.add(-num);
				queue.add(new Point(j,num));
			}
			int max_num = -max.peek(); // 제일 높은 중요도
			int answer = 0;
			while(true) {
				Point p = queue.poll();
				if(p.y == max_num) {
					answer++;
					if(p.x==m) break;
					max.poll();
					max_num = -max.peek();
				}
				else {
					queue.add(p);
				}
			}
			System.out.println(answer);
		}
		
		
	}
	
	
}