import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
*   방향그래프
* 정점 개수 V
* 간선 개수 E
* u -> v 가중치 w
 */
public class Main {
    static ArrayList<Point>[] arr;
    static int[] length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        arr = new ArrayList[V+1];
        length = new int[V+1];
        Arrays.fill(length,Integer.MAX_VALUE);
        for(int i=1; i<=V; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<E; i++){  // 그래프 정보 저장
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            arr[from].add(new Point(to,dist));
        }
        length[start] = 0;
        dijk(new Point(start,0));
        for(int i=1; i<=V; i++){
            if(length[i]==Integer.MAX_VALUE) sb.append("INF\n");
            else sb.append(length[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dijk(Point start){
        PriorityQueue<Point> queue = new PriorityQueue<>((a,b)->{
            return a.dist - b.dist;
        });
        queue.add(start);
        while(!queue.isEmpty()) {
            start = queue.poll();
            for (Point point : arr[start.x]) {
                if(length[point.x] > length[start.x]+point.dist){
                    length[point.x] = Math.min(length[point.x], length[start.x] + point.dist);
                    queue.add(new Point(point.x,length[point.x]));
                }

            }
        }
    }
    static class Point{
        int x, dist;
        public Point(int x, int dist){
            this.x = x;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return this.x+" "+this.dist;
        }
    }
}