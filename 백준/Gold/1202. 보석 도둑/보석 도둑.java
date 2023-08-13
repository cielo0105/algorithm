import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    총 N개의 보석
    무게 M 가격 V
    가방에 최대 C (1개 보석만)
    보석 최대 가격
 */
public class Main {
    static Jewelry[] jew;
    static int[] bag;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long answer = 0;
        jew = new Jewelry[N];
        bag = new int[K];
        int w,c;
        for(int i=0; i<N; i++){ // 보석 정보 저장
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            jew[i] = new Jewelry(w,c);
        }
        for(int i=0; i<K; i++){ // 가방 정보 저장
            bag[i] = (Integer.parseInt(br.readLine()));
        }
        Arrays.sort(bag);
        Arrays.sort(jew,(a,b)->{ // 보석 무게 기준으로 오름차순
            if(a.weight == b.weight) return b.cost - a.cost;
            return a.weight - b.weight;
        });
        pq = new PriorityQueue<>(Comparator.reverseOrder()); // 보석 가격 순으로 내림차순(비싼거 먼저)
        int idx = 0;
        for(int bagW: bag){
            while(idx<N && jew[idx].weight <= bagW){
                pq.offer(jew[idx++].cost);
            }
            if(!pq.isEmpty()){
                answer += pq.poll();
            }
        }
        System.out.println(answer);
    }


    public static class Jewelry{
        int weight, cost;
        public Jewelry(int weight, int cost){
            this.weight = weight;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return this.weight +" "+cost;
        }
    }
}