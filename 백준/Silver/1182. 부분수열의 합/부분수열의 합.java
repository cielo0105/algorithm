import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 N개로 이루어진 집합
 부분집합 합 S되는 경우의 수
 */
public class Main {
    static int n,s;
    static int[] number;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        answer = 0;
        number = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int j=0; j<n; j++){
            number[j] = Integer.parseInt(st.nextToken());
        }
        search(0,0);
        if(s==0) answer -= 1;
        System.out.println(answer);

    }
    static void search(int nth, int sum){
        if(nth == n){
            if(sum==s) answer++;
            return;
        }
        search(nth+1,sum);
        search(nth+1, sum+number[nth]);
    }

}