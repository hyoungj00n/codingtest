import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        
        Map<String,String> user = new HashMap<>();
        int count =0;
        for(int i = 0; i < record.length; i++){
            String[] check = record[i].split(" ");
            switch(check[0]){
                case "Enter":
                    user.put(check[1],check[2]);
                case "Change":
                    user.put(check[1],check[2]);
                    
            }
        }
        
        

        for(int i = 0; i < record.length; i++){
            String[] check = record[i].split(" ");
        
            if(check[0].equals("Leave")){
                list.add(user.get(check[1])+"님이 나갔습니다.");
            }else if(check[0].equals("Enter")){
                list.add(user.get(check[1])+ "님이 들어왔습니다.");
            }
        }
        answer = list.stream().toArray(String[]::new);
        return answer;
    }
}