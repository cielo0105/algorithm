import java.util.*;
class Solution {
    boolean[] visited;
    int[][] dun;
    int answer = 0;
    int len;
    public int solution(int k, int[][] dungeons) {
        len = dungeons.length;
        visited = new boolean[len];
        
        dun = dungeons;
        System.out.println(len);
        find(0,k);
        return answer;
    }
    public void find(int nth,int energy){
       
        for(int i=0; i<len; i++){
            if(!visited[i]){
                if(energy >= dun[i][0]){
                    visited[i] = true;
                    find(nth+1,energy-dun[i][1]);
                    visited[i] = false;
                }
            }
           
        }
        answer = Math.max(answer,nth);
    }
}