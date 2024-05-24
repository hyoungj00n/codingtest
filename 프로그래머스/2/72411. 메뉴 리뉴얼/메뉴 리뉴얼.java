import java.util.*;
import java.util.Map.*;
class Solution {
    static HashMap<String,Integer> map;
    static void dfs(String order, int n, StringBuilder sb,int depth,int idx){
        if(depth == n){
            map.put(sb.toString(), map.getOrDefault(sb.toString(),0)+1);
            return;
        }
        
        for(int i = idx; i < order.length(); i++){
            sb.append(order.charAt(i));
            dfs(order, n, sb, depth+1, i+1);
            sb.delete(depth,depth+1);
        }
    }
    
    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        
                
        for(int i =0;i<orders.length;i++){
            
            char[] charArr = orders[i].toCharArray();
            Arrays.sort(charArr);
            orders[i] = String.valueOf(charArr);
        }
        
        
        for(int i = 0; i < course.length; i++){
            int max = -1;
            map = new HashMap<>();
            for(int j = 0; j < orders.length; j++){
                StringBuilder sb = new StringBuilder();
                if(course[i] <= orders[j].length()){
                    dfs(orders[j],course[i],sb,0,0);
                }
                
            }
            
            for(Entry<String,Integer> entry : map.entrySet()){
                max = Math.max(max,entry.getValue());
            }
            
            for(Entry<String,Integer> entry : map.entrySet()){
                if(max >=2 && entry.getValue() == max){
                    answer.add(entry.getKey());
                }
            }
            
            
            
        }
        
        Collections.sort(answer);
        
        
        return answer;
    }
}