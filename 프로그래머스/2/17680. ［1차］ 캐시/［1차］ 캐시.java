import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> deque = new LinkedList<>();
        int time = 0;
        if(cacheSize == 0){
            return cities.length * 5;
        }
        for(int i = 0; i < cities.length; i++){
            String city = cities[i].toLowerCase();
            if(deque.contains(city)){
                time += 1;
                int s = deque.size();
                if(s== 1){
                    continue;
                }
            
                for(int j = 0; j < s; j++){
                    String temp = deque.poll();
                    if(temp.equals(city)){
                        continue;
                    }
                    deque.add(temp);
                }

                deque.add(city);
                continue;
            }else{
                time += 5;
            }
            
            if(deque.size() >= cacheSize){
                deque.poll();
            }
            deque.add(city);
            
        }
        return time;
    }
}

