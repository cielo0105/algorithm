import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            char[] word = st.nextToken().toCharArray();
            for(char c:word){
                for(int j=0; j<cnt;j++){
                    System.out.print(c);
                }
            }
            System.out.println();
        }


    }
}