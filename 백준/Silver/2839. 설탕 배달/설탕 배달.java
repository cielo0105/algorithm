import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 정확히 N kg 배달
 3,5kg 봉지
 */
public class Main {
    static int N;
    static int flag = 0;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        find(0,0);
        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);
    }
    static void find(int cnt, int total){
        if(total > N || flag == 1) return;
        if(total == N){
            min = min > cnt ? cnt : min;
            flag = 1;
            return;
        }
        find(cnt+1, total+5);
        find(cnt+1,total+3);
    }
}