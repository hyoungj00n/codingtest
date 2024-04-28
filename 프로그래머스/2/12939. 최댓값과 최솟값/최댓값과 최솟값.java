import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        String[] splitResult = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< splitResult.length; i++){
            list.add(Integer.parseInt(splitResult[i]));
        }
        answer = Collections.min(list) + " " + Collections.max(list);
        return answer;
    }
}