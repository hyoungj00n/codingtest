import java.util.*;
class Solution {
    static int preX = 0;
    static int preY = 0;
    static int x = 0;
    static int y = 0;
    
    public int solution(String dirs) {     
        HashSet<String> set=new HashSet<>();
    
        for(int j = 0; j < dirs.length(); j++){      
            switch(dirs.charAt(j)){
                case 'U':
                    y += 1;
                    
                    break;
                case 'L':
                    x -= 1;
                    
                    break;
                case 'D':
                    y -= 1;
                    
                    break;
                case 'R':
                    x += 1;
                    
                    break;
                
            }
             
        
        if(y<-5||x<-5||y>5||x>5){
                y=preY;
                x=preX;
                continue;
        }
        int arr[][]={{y,x},{preY,preX}};
        
        Arrays.sort(arr,new Comparator<>(){
               @Override
                public int compare(int arr1[],int arr2[]){
                    if(arr1[0]>arr2[0])
                        return 1;
                    else if(arr1[0]==arr2[0]){
                        if(arr1[1]>arr2[1]) return 1;
                    }
                    
                    return -1;
                }
            });
        set.add(arr[0][0]+" "+arr[0][1]+" "+arr[1][0]+" "+arr[1][1]);
        preY=y;
        preX=x;
        }
        return set.size();
    }
}