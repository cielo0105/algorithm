import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 높이가 B인 선반
 점원 키 H
 탑 높이는 점원 키 합 -> 최소
 */
public class Solution {
    static int n,b;
    static int[] height;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=1; i<=T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            height = new int[n];
            min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                height[j] = Integer.parseInt(st.nextToken());
            }
//            Arrays.sort(height);
            find(0,0);
            sb.append(String.format("#%d %d\n",i,min));
        }
        System.out.println(sb);
    }
    static void find(int depth, int sum){
        if(depth == n){
            if(sum >= b){
                min = min > (sum-b) ? (sum-b) : min;
            }
            return;
        }

        find(depth+1, sum+height[depth]);
        find(depth+1, sum);

    }
}