import java.util.*;
import java.lang.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int count = 0;
        for(int i = citations.length-1; i >= 0; i--){
            if(citations[i]>count++){
                answer = count;
            }
            
        }
        return answer;
    }
}