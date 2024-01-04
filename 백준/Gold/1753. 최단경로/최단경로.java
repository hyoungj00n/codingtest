import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class Main{

    static int V,E,start;

    static int[] dist;
    static ArrayList[] graph;

    public static class Node implements Comparable<Node>{
        int v,w;

        public Node(int v, int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node n) {

            return this.w - n.w;
        }
    }

    public static void dijckstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();


            int len = graph[now.v].size();

            for(int i =0; i<len; i++){
                Node next = (Node)graph[now.v].get(i);

                if (dist[next.v] > next.w+ now.w){
                    dist[next.v] = next.w + now.w;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }

        }
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        dist = new int[V+1];

        for (int i=1; i<=V; i++){
            graph[i] = new ArrayList<Node>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(V,W));

        }

        dijckstra(start);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=V; i++){
            if(dist[i] == Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");
        }

        System.out.print(sb);

    }



}