class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i =0; i< n; i++){
            answer[i] = "";
        }
        for(int i = 0; i < n; i++){
            
            for(int j = 0; j < n; j++){
                
                int temp1 = arr1[i] % 2;
                int temp2 = arr2[i] % 2;
                
                arr1[i] = arr1[i] / 2;
                arr2[i] = arr2[i] / 2;
                if(temp1 == 1 || temp2 == 1){
                    answer[i] += "#";
                }
                else{
                    answer[i] += " ";
                }
            }
            StringBuffer sb = new StringBuffer(answer[i]);        
            answer[i] = sb.reverse().toString();
            
        }
        
        
        return answer;
    }
}