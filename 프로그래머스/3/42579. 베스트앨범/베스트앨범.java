import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, HashMap<Integer, Integer>> map = new HashMap<>();
        Map<String, Integer> music = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++){
            if(!music.containsKey(genres[i])){
            HashMap<Integer, Integer> temp = new HashMap<>();
            temp.put(i, plays[i]);
            map.put(genres[i], temp);
            music.put(genres[i], plays[i]);
            }else{
                music.put(genres[i], music.get(genres[i]) + plays[i]);
                map.get(genres[i]).put(i,plays[i]);
            }
        }
    
        
        List<String> arrList = new ArrayList(music.keySet());
        Collections.sort(arrList, (o1, o2) -> music.get(o2) - music.get(o1));
        
        for(String arr : arrList){
            
            HashMap<Integer,Integer> tempMap = map.get(arr);
            System.out.println(tempMap.keySet());
            ArrayList<Integer> list = new ArrayList(tempMap.keySet());
            
            Collections.sort(list, (o1,o2) -> tempMap.get(o2) - tempMap.get(o1));
            
            answer.add(list.get(0));
            
            if(list.size()>1){
                answer.add(list.get(1));
            }
        }
        
        
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}