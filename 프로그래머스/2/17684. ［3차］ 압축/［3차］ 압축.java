import java.util.*;
class Solution {
    public List<Integer> solution(String msg) {
        List<Integer> list = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int index = 1;
        for(char i = 'A'; i<='Z'; i++){
            map.put(i+"",index++);
        }
        int count = 27;
        
        for(int i = 0; i < msg.length(); i++){
            int j = 1;
            while(i+j <= msg.length() && map.containsKey(msg.substring(i,i+j))){
                j++;
            }
            if(i+j>msg.length()){
                list.add(map.get(msg.substring(i)));
                break;
            }
            list.add(map.get(msg.substring(i,i+j-1)));
            map.put(msg.substring(i,i+j),count++);
            if(j>1)i+=j-2;
            
        }
        return list;
        
    }
}