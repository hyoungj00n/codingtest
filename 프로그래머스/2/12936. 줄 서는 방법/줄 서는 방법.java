import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
     List<Integer> lst = new ArrayList<>(); 
        for(int i=1; i<=n; i++)lst.add(i);
        int[] answer = new int[n];
        
        k=k-1; 
        int index=0;
        for(int i=n; i>0; i--){
            long temp = factorial(i-1);
            int a= (int) (k/temp);
            answer[index++]= lst.get(a);
            lst.remove(a);
            k = k%temp;
        }
        return answer;
        
    }
    public long factorial(int n){
        long num =1;
        for(int i=n; i>=1; i--){
            num*=i;
        }
        return num;
    }
   
}