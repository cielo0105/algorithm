import java.io.*;

public class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        String num = n+"";
        int num = (n+"").length();
        int answer = 0;
        for(int i=n-num*9; i<=n; i++){
            if(i+calc(i) == n){
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
    static int calc(int n){ // 각 자릿수 합
        int sum = 0;
        int len = (n+"").length();
        String num = n+"";
        for(int i=0; i<len; i++){
            sum += num.charAt(i)-'0';
        }

        return sum;
    }
}