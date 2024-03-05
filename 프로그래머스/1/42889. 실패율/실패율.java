import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> map = new HashMap<>();
        double p = stages.length; //8
        int[] fail = new int[N+2]; // 스테이지별 실패자 수
        
        for(int i = 1; i < N+2; i++){
            fail[i] = 0;
        }
        
        for(int i = 0; i < stages.length; i++){
            fail[stages[i]]++;
        }
        
        for(int i = 1; i < N+1; i++){
            
            if(p == 0){
                map.put(i, 0.0);
                continue;
            }
            
            map.put(i,(double)fail[i] / p);
            p = p - fail[i];
        
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list,(o1,o2) -> Double.compare(map.get(o2), map.get(o1)));
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}