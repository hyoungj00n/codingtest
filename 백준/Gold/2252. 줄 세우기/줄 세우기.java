import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nm =br.readLine().split(" ");
        ArrayList<Integer> result = new ArrayList<>();

        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        int[] inDegree = new int[N+1];

        for (int i = 0; i <= N+1; i++){
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++){
            String[] g = br.readLine().split(" ");
            graph.get(Integer.parseInt(g[0])).add(Integer.parseInt(g[1]));
            inDegree[Integer.parseInt(g[1])]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i =1; i<inDegree.length; i++){
            if (inDegree[i]==0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){

            int student = queue.poll();

            bw.write(String.valueOf(student) + " ");

            List<Integer> list = graph.get(student);

            for (int i = 0; i< list.size(); i++){
                int temp = list.get(i);

                inDegree[temp]--;

                if (inDegree[temp] == 0){
                    queue.add(temp);
                }
            }

        }

        bw.flush();


    }
}
