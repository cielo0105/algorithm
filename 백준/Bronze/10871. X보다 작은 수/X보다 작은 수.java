import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        String[] arr = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        for(String s:arr){
            if(Integer.parseInt(s) < x){
                list.add(Integer.parseInt(s));
            }
        }
        for(int i:list){
            System.out.print(i+" ");
        }
    }
}