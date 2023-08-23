import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] input = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        int[] cnt = new int[200001];
        int start = 0;
        int end = 0;
        int max = 0;
        int count = 0;

        while(end<N){
            if(cnt[input[end]] < K){
                cnt[input[end++]]++;
                count++;
            }
            else{
                max = Math.max(max,count);
                cnt[input[start++]]--;
                count--;
            }
        }
        max = Math.max(max,count);
        System.out.println(max);

    }
}