import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < operations.length; i++){
            String[] splitResult = operations[i].split(" ");
            if(operations[i].charAt(0) == 'I'){
                list.add(Integer.parseInt(splitResult[1]));
            }
            else{
                if(list.size() == 0){
                    continue;
                }
                if(Integer.parseInt(splitResult[1]) == 1){
                    list.remove(list.size()-1);
                }else{
                    list.remove(0);
                }
            }
            Collections.sort(list);
            
        }
        if(list.size()==0){
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }
        answer[1] = list.get(0);
        answer[0] = list.get(list.size()-1);
        return answer;
    }
}