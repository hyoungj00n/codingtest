import java.util.*;
class Solution {
    static class File{
        String head;
        int num;
        String name;
        
        File(String head, int num, String name){
            this.head = head;
            this.num = num;
            this.name= name;
        }
    }
    public String[] solution(String[] files) {
        
        File[] fileInfo = new File[files.length];
        for(int i = 0; i < files.length; i++){
            String[] splitFilesResult = splitFiles(files[i]);
            fileInfo[i] = new File(splitFilesResult[0], Integer.parseInt(splitFilesResult[1]), files[i]);
        }
        
        Arrays.sort(fileInfo, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2){
                if(o1.head.equals(o2.head)){
                    return o1.num - o2.num;
                }else{
                    return o1.head.compareTo(o2.head);    
                }
                 
            }
        });
        String[] answer = new String[files.length];
        for (int i = 0; i < files.length; i++) {
            answer[i] = fileInfo[i].name;
        }
        return answer;
    }
    
    
    public static String[] splitFiles(String file){
        String[] result = new String[3];
        result[0] = "";
        result[1] = "";
        result[2] = "";
        int idx = 0;
        for(int i = 0; i < file.length(); i++){
            char c = file.charAt(i);
            
            if(idx == 0 && !Character.isDigit(c)){
                result[idx] += c;
                continue;
            }
            
            if(idx == 0 && Character.isDigit(c)){
                idx++;
            }
            
            if(idx == 1 && Character.isDigit(c)){
                result[idx] += c;
                continue;
            }
            
            if(idx == 1 && !Character.isDigit(c)){
                idx++;
            }
            
            result[idx] += c;
        }
        result[0] = result[0].toLowerCase();
        return result;
    }
}