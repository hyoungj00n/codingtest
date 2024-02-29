import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] choice = {0,3,2,1,0,1,2,3};
        Character[] a = {'T', 'R', 'F', 'C', 'M', 'J','N', 'A'};
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<a.length; i++){
            map.put(a[i],0);
        }
        
        for(int i = 0; i < survey.length; i++){
            Character c1 = survey[i].charAt(0);
            Character c2 = survey[i].charAt(1);
            if(choices[i] < 4){
                map.put(c1, map.get(c1)+choice[choices[i]]);    
            }
            else{
                map.put(c2, map.get(c2)+choice[choices[i]]);
            }
            
        }
        
        for(int i = 0; i < a.length-1; i+=2){
            if(map.get(a[i]) > map.get(a[i+1])){
                answer += a[i];
            }
            else if(map.get(a[i]) < map.get(a[i+1])){
                answer += a[i+1];
            }
            else{
                answer += a[i+1];
            }
        }
        
      

        return answer;
    }
}