import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Map.Entry;

import javax.print.attribute.HashPrintJobAttributeSet;

/**

@author 임현지
@since 2023. 8. 4.

@note 
*
* 절사평균
* 위에서 15% 아래에서 15% 값 제외하고 평균 구함 (반올림)
* *0.15
*/

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		float sum = 0;
		List<Integer> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(list);
		int remove = (int) Math.round(n*0.15);
		for(int i=remove; i<n-remove; i++) {
			sum += list.get(i);
		}
		int avg =(int) Math.round(sum/(n-2*remove));
		System.out.println(avg);
	}
	

}