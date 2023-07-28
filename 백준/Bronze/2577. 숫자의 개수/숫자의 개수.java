import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long ans = 1;
        int[] cnt = new int[10];
        for(int i=0; i<3; i++){
            ans *= Long.parseLong(br.readLine());
        }

        char[] calc = Long.toString(ans).toCharArray();
        for(char c:calc){
            cnt[c-'0'] += 1;
        }
        for(int c:cnt){
            System.out.println(c);
        }


    }
}