import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> s1 = new ArrayList<>();
        List<String> s2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> inter = new ArrayList<>();
        
        for(int i = 0; i < str1.length()-1; i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            
            if(Character.isLetter(c1) && Character.isLetter(c2)){
                String s = Character.toString(c1)+ Character.toString(c2);
                s1.add(s);
            }
        }
        
        for(int i = 0; i < str2.length()-1; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            
            if(Character.isLetter(c1) && Character.isLetter(c2)){
                String s = Character.toString(c1)+ Character.toString(c2);
                s2.add(s);
            }
        }
    
        Collections.sort(s1);
        Collections.sort(s2);
        
        for(String s : s1){
            if(s2.remove(s)){
                inter.add(s);
            }
            union.add(s);
        }
        
        for(String s : s2){
            union.add(s);
        }
        if(union.size() == 0){
            return 1 * 65536;
        }
        double result = 0;
        
        result = (double)inter.size() / (double)union.size();
        System.out.println(result);
        return (int)(result * 65536);
        
    }
}