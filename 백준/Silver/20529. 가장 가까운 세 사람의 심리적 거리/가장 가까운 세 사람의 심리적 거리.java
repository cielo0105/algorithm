import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
    IOI
    IOIOI
    IOIOIOI 개수
 */
public class Main {
    static int N;
    static String[] mbti;
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            mbti = new String[N];
            mbti = br.readLine().split(" ");
            min = Integer.MAX_VALUE;
            comb(0,0,new String[3]);
            sb.append(min).append("\n");
        }
        System.out.println(sb);
    }
    static void comb(int depth, int start, String[] choose){
        if(min == 0) return;
        if(depth == 3){
            check(choose);
            return;
        }
        for(int i=start; i<N; i++){
            choose[depth] = mbti[i];
            comb(depth+1,i+1,choose);
        }
    }

    static void check(String[] choose){
        int cnt = 0;
        for(int i=0; i<2; i++){
            for(int j=i+1; j<3; j++){
                cnt += diff(choose[i],choose[j]);
            }
        }
        min = Math.min(min,cnt);
    }
    static int diff(String a, String b){
        int cnt = 0;
        for(int i=0 ;i<4; i++){
            if(a.charAt(i) != b.charAt(i)) cnt++;
        }
        return cnt;
    }
}