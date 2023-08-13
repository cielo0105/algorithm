import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
    0이면 절댓값 가장 작은 값 출력 (여러개면 - 먼저 출력)
    비어있는데 0 오면 0 출력
 */
public class Main {
    static int[] num;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int n;
        int[] polled;
       for(int i=0; i<N; i++){
            n = Integer.parseInt(br.readLine());
            if(n==0){
                if(pq.isEmpty()) sb.append(0).append("\n");
                else{
                    polled = pq.poll();
                    sb.append(polled[0]*polled[1]).append("\n");
                }
            }
            else{
                if(n>0){
                    pq.offer(new int[] {n,1});
                }
                else pq.offer(new int[]{n*-1,-1});
            }
        }
        System.out.println(sb);


    }
}