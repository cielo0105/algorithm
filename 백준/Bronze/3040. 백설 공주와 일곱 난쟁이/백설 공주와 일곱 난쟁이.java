import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    일곱 난쟁이 모자 합 = 100
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int n;
        int [] num = new int[9];
        for (int i = 0; i < 9; i++) {
            n = Integer.parseInt(br.readLine());
            sum += n;
            num[i] = n;
        }
        int find = sum-100;
        int a = 0;
        int b = 0;
        loop:
        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                if(num[i]+num[j] == find){
                    a = num[i];
                    b = num[j];
                    break loop;
                }
            }
        }
        for(int nu:num){
            if(nu == a || nu == b) continue;
            sb.append(nu).append("\n");
        }
        System.out.println(sb);
    }
}