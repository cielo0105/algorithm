import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
// 오른쪽 위
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        List<Integer> diag = new ArrayList<>();
        List<Integer> vert = new ArrayList<>();
        int type,loc;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            type = Integer.parseInt(st.nextToken());
            loc = Integer.parseInt(st.nextToken());
            if(type==0) diag.add(loc);
            else vert.add(loc);
        }
        diag.add(0);
        diag.add(height);
        vert.add(0);
        vert.add(width);
        Collections.sort(diag);
        Collections.sort(vert);
        int a = getMax(diag);
        int b = getMax(vert);
        System.out.println(a*b);
    }
    static int getMax(List<Integer> list){
        int max = Integer.MIN_VALUE;
        int diff;
        for(int i=0; i<list.size()-1; i++){
            diff = list.get(i+1) - list.get(i);
            max = max < diff ? diff : max;
        }
        return max;
    }
}