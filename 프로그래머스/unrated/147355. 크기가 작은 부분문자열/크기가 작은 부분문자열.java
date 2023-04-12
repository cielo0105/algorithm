class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        long p_value = Long.parseLong(p);
        int leng = p.length();
        // System.out.println(t.substring(0,3));
        
        for(int i=0;i<=t.length()-p.length();i++){
            long t_value = Long.parseLong(t.substring(i,i+leng));
            if(t_value <= p_value)
                answer++;  
        }
        return answer;
    }
}