import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> nq = new PriorityQueue<>();
    static int zero = 0;
    static int sum = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int num;
        for(int i=0; i<N; i++){
            num = Integer.parseInt(br.readLine());
            if(num==1) sum += 1;
            else if(num>0) pq.add(num);
            else if(num<0) nq.add(num);
            else zero++;
        }
        calc(pq);
        calc(nq);
        System.out.println(sum);
    }

    static void calc(PriorityQueue<Integer> arr){
        while(arr.size() > 1){
            sum += arr.poll() *  arr.poll();
        }
        if(!arr.isEmpty()){
            int n = arr.poll();
            if(n<0 && zero > 0){ // 음수인 경우 0이 존재하면 0 곱해주는 것이 좋음
                zero--;
            }
            else sum += n;
           
        }
    }

}