import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,K;
    static int flag = 0;
    static int[] cnt = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt[N] = 0;
        find(N);
        System.out.println(cnt[K]);
    }
    static void find(int n){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        while(!queue.isEmpty()){
            n = queue.poll();
            if(n==K) break;
            if(n+1<=100000 && cnt[n+1]==0){
                cnt[n+1] = cnt[n] + 1;
                queue.add(n+1);
            }
            if(n-1>=0 && cnt[n-1]==0){
                cnt[n-1] = cnt[n] + 1;
                queue.add(n-1);
            }
            if(n*2<=100000 && cnt[n*2]==0){
                cnt[n*2] = cnt[n]+1;
                queue.add(n*2);
            }

        }


    }
}