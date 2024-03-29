import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 9876543210
public class Main {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N<=10) System.out.println(N);
        else if(N>=1023) System.out.println(-1);
        else {
            for (int i = 0; i < 10; i++) {
                find(1, i);
            }
            Collections.sort(list);
            System.out.println(list.get(N));
        }
    }

    static void find(int idx, long num){
        if(idx > 10){ // 10의 자릿수
            return;
        }
        list.add(num);
        for(int i=0; i<num%10; i++){
            find(idx+1,(num*10)+i);
        }
    }
}