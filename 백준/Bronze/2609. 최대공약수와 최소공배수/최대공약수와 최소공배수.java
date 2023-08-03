import java.io.*;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        sb.append(gdc(a,b)).append("\n").append(lcm(a,b));
        System.out.println(sb);
    }
    static int gdc(int a, int b){ // 최대공약수
        if(a<b){
            int temp = a;
            a = b;
            b = temp;
        }
        while(b>0){
            int r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
    static int lcm(int a, int b){
        return a*b/gdc(a,b);
    }
}