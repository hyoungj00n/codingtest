import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        int flag=0;
        List<Integer> list = new ArrayList<>();
        
        String[] date = today.split("\\.");
        int d = Integer.parseInt(date[0])*28*12 + Integer.parseInt(date[1]) * 28 + Integer.parseInt(date[2]);
        
        HashMap<String,String> map = new HashMap<>();
        for(int i = 0; i< terms.length; i++){
            String[] term = terms[i].split(" ");
            map.put(term[0], term[1]);
        }
        
        for(int i = 0; i< privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            String[] p = privacy[0].split("\\.");
            
            int compare = Integer.parseInt(p[0]) * 28*12 + Integer.parseInt(p[1]) * 28 +Integer.parseInt(p[2]);
            
            if (d >= (Integer.parseInt(map.get(privacy[1])) * 28) + compare){
                list.add(i+1);
                
            } 
            
        }
        answer = new int[list.size()];
        for (int i =0; i< list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
        
    }
}