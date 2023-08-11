import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()); // 처음 길이
        int[] height = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(height);
        for(int i=0; i<N; i++){
            if(height[i] <= L) L++;
            else break;
        } 
        System.out.println(L);
    }

}