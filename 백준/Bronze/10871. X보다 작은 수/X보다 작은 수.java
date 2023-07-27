import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for(String s:arr){
            if(Integer.parseInt(s) < x){
                sb.append(s).append(" ");
            }
        }
        System.out.println(sb);
    }
}