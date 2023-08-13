import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] num;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        if(N==1) System.out.println(1);
        else {

            int inc = getInc();
            int dec = getDec();

            System.out.println(Math.max(inc, dec));
        }
    }
    static int getDec(){
        int max = Integer.MIN_VALUE;
        int cnt = 1;
        for(int i=1; i<N; i++){
            if(num[i-1] >= num[i]){
                cnt++;
            }
            else{
                cnt = 1;
            }
            max = max < cnt ? cnt: max;
        }

        return max;
    }
    static int getInc(){
        int max = Integer.MIN_VALUE;
        int cnt = 1;
        for(int i=1; i<N; i++){
            if(num[i-1] <= num[i]){
                cnt++;
            }
            else{
                cnt = 1;
            }
            max = Math.max(max,cnt);
        }

        return max;
    }

}