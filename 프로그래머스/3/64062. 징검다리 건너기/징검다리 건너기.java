class Solution {
    static boolean find(int n, int[] stones, int k){
        int count = 0;
        
        for(int stone : stones){
            
            if(stone-n <0){
                count++;
            }else{
                count = 0;
            }
            
            if(count == k){
                return false;
            }
            
        }

        
        return true;
    }
    public int solution(int[] stones, int k) {
        int answer = 0;
        int min = 1;
        int max = 200000000;
        
        while(min <=max){
            int mid = (min + max) / 2;
            if(find(mid, stones,k)){
                min = mid+1;
                answer = Math.max(mid,answer);
                
            }else{
                max = mid-1;
            }
            
        }
        return answer;
    }
}