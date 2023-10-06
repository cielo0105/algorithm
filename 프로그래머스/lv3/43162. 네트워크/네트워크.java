import java.util.*;
class Solution {
    static boolean[] visited;
    static ArrayList<Integer>[] link;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        link = new ArrayList[n];
        for(int i=0; i<n; i++){
            link[i] = new ArrayList<>();
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(computers[i][j] == 1) link[i].add(j);
            }
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                answer++;
                bfs(i);
            }
        }
        return answer;
        
       
    }
    public static void bfs(int num){
            Queue<Integer> q = new ArrayDeque();
            q.add(num);
            while(!q.isEmpty()){
                num = q.poll();
                for(int next:link[num]){
                    if(!visited[next]){
                        visited[next] = true;
                        q.add(next);
                    }
                }
            }
        }
}