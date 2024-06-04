class Solution
{
    
    
    public int solution(String s)
    {
        int answer = 0;
        
        for(int i = s.length(); i > 0; i--) {
            for(int j = 0; j+i <= s.length(); j++) {
                boolean flag =true;
                int start = j;
                int end = i+j-1;
                
                while(start <= end) {
                    if(s.charAt(start++) != s.charAt(end--)){
                        flag = false;
                        break;
                    }
                    
                }
                if (flag){
                    answer =  Math.max(i, answer);
                }
            }
        }

        
        return answer;
    }
}