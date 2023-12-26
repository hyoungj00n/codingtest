import java.util.*;
class Solution {
    public String solution(String s) {
       String answer = "";
        String[] words = s.toLowerCase().split("");
        
        boolean flag = true;
        
        for (String word : words){
            if(flag == true){
                answer += word.toUpperCase();
            }
            else{
                answer += word;
            }
            
            if(word.equals(" ")){
                flag = true;
            }
            else{
                flag = false;
            }
            
        }
        return answer;
        
    }
}