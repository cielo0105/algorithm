import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[6];
        for(int i=0; i<6; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=-999;i<=999;i++){
            for(int j=-999;j<=999;j++){
                if(input[0]*i+input[1]*j==input[2] && input[3]*i+input[4]*j==input[5]){
                    System.out.println(i+" "+j);
                }
            }
        }
    }
}
