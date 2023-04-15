import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        // int[] answer = {};
        List<Integer> answer = new ArrayList<>();
        int[] days = new int[progresses.length];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            if((100-progresses[i])%speeds[i] != 0){
                q.add((100-progresses[i])/speeds[i] + 1);
            }else{
                q.add((100-progresses[i])/speeds[i]);
            }
        }  // q = 7,3,9
        int x = q.poll();
        int count = 1;
        while(!q.isEmpty()){
            if(x>=q.peek()){
                count++;
                q.poll();
            }
            else{
                answer.add(count);
                count = 1;
                x = q.poll();
            }
        }
        answer.add(count);
        int[] ans = new int[answer.size()];
        for(int i=0;i<answer.size();i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}