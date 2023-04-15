import java.util.*;

public class Solution {
    public int solution(int n) {
        String num = Integer.toString(n);
        int answer = 0;
        for(int i=0;i<num.length();i++){
            answer += Integer.parseInt(num.substring(i,i+1));
        }
            
        
        return answer;
    }
}