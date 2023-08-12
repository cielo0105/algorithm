import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int number;
        st.nextToken();
        list.add(1);
        for(int i=2; i<=N; i++){
            number = Integer.parseInt(st.nextToken());
            list.add(i-1-number,i);
        }
        for(int i:list){
            sb.append(i).append(" ");
        }
        System.out.println(sb);

    }

}