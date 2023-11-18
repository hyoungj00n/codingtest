import java.io.*;
import java.util.*;

public class Main {

    static int result;
    static boolean[] visited;
    static List<Node>[] arrayList;

    static class Node implements Comparable<Node>{

        int to;
        int value;

        public Node(int to, int value){
            this.to = to;
            this.value = value;
        }
        @Override
        public int compareTo(Node n){
            return this.value - n.value;
        }

    }
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int V = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        visited = new boolean[V+1];
        arrayList = new ArrayList[V+1];

        for(int i =1; i<V+1; i++){
            arrayList[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            String[] tmp = br.readLine().split(" ");
            int a = Integer.parseInt(tmp[0]);
            int b = Integer.parseInt(tmp[1]);
            int w = Integer.parseInt(tmp[2]);
            arrayList[a].add(new Node(b,w));
            arrayList[b].add(new Node(a,w));

        }

        prim(1);
        System.out.println(result);


    }

    static void prim(int start){
        Queue<Node> queue = new PriorityQueue<>();

        queue.add(new Node(start,0));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int to = node.to;
            int value = node.value;

            if (visited[to] == true){
                continue;
            }
            visited[to] = true;
            result+= value;

            for(Node next : arrayList[to]){
                if(!visited[next.to]){
                    queue.add(next);
                }
            }
        }
    }
}
