class Solution {
    public int solution(int n) {
        int answer = 0;
        int start = 0;
        int end = 0;
        int[] num = new int[n];
        for(int i=0;i<n;i++){
            num[i] = i+1;
        }
        
        int total = num[0];
        while(start<=end){
          
            if(total<n){
                end++;
                total += num[end];
            }
            else if(total==n){
                answer++;
                total -= num[start];
                start++;
            }
            else{
                total -= num[start];
                start++;
            }
        }
        
        return answer;
    }
}