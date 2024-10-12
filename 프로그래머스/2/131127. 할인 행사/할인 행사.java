import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        int[] day = new int[discount.length];
        int count = 0;
        
        for(int i = 0; i < want.length; i++){
            map.put(want[i], number[i]);
            
        }
        
        for(int i = 0; i < discount.length-9; i++){
            boolean flag = true;
            Map<String,Integer> check = new HashMap<>();
            
            for(int j = 0; j < 10; j++){
                check.put(discount[i+j], check.getOrDefault(discount[i+j], 0) + 1);
            }
            
            for(Map.Entry<String,Integer> entity : check.entrySet()){
                if(map.get(entity.getKey()) == entity.getValue()){
                    continue;
                }else{
                    flag = false;
                }
                    
            }
            if(flag){
                answer++;
            }
            
        }
        
        
        return answer;
    }
}