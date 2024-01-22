import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main{




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < N; i++){

            String[] s = br.readLine().split("\\.");

            hashMap.put(s[1],hashMap.getOrDefault(s[1], 0)+1);

        }

        Set<String> strings = hashMap.keySet();

        List<String> list = new ArrayList<>(strings);

        Collections.sort(list);

        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i)+" "+hashMap.get(list.get(i)));
        }


    }



}
