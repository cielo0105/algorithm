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
@since 2023. 8. 3.
@see
@git
@youtube
@performance
@category #
@note 
*
* n의 자리에 2,3,5,7 만 존재 가능
* 그 이후는 1,2,3,5,7,9
* 소수 체크
*/

public class Main {
	static int n;
	static int[] number = {1,2,3,5,7,9};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		prime("");
		
		
	}
	
	static void prime(String num) {
		if(num.length()==n) {
			System.out.println(num);
			return;
		}
		
		for(int i=0; i<number.length;i++) {
			String nextNum = num + number[i];
			if(check(Integer.parseInt(nextNum))) {
				prime(nextNum);
			}
			
		}
	}
	
	static boolean check(int n) { // 소수인지 확인
		if(n==1) return false;
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i==0) return false;
		}
		return true;
	}

}