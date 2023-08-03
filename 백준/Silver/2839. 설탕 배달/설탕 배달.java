import java.io.*;

public class Main
{
    static int n;
    static int answer = -1;
    static int flag = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 3kg, 5kg 봉지 - 최대한 봉지 적게  (중복조합)
        n = Integer.parseInt(br.readLine());
        find(0,0);
        System.out.println(answer);
    }
    static void find(int w, int cnt){ // w는 현재까지 무게
        if(w>n || flag == 1) return;
        if(w==n) {
            answer = cnt;
            flag = 1;
            return;
        }
        find(w+5,cnt+1);
        find(w+3,cnt+1);
    }
}