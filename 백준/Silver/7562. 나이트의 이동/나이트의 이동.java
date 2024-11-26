import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

class Point {

    int x,y,count;
    Point(int x, int y,int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Main {

    static boolean[][] visited;
    static int result;
    static int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static int[] dy = {2,1,-1,-2,-2,-1,1,2};
    static void bfs(Point now, Point arrive, int l){



        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(now.x,now.y, now.count));
        visited[now.x][now.y] = true;

        while(!queue.isEmpty()){

            Point p = queue.poll();

            for(int i = 0; i < 8; i++){
                int cx = p.x + dx[i];
                int cy = p.y + dy[i];


                if(cx >= 0 && cy >= 0 && cx < l && cy < l && !visited[cx][cy]){

                    if (arrive.x == cx && arrive.y == cy){
                        result = Math.min(result, p.count+1);
                        return;
                    }

                    visited[cx][cy] = true;
                    queue.add(new Point(cx,cy,p.count+1));

                }

            }


        }

    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            int l = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE;
            visited = new boolean[l][l];

            int[] now = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] arrive = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

            if (now[0] == arrive[0] && now[1] == arrive[1]) {
                sb.append(0).append('\n');
                continue;
            }

            bfs(new Point(now[0],now[1],0),new Point(arrive[0],arrive[1],0), l);

            sb.append(result).append('\n');


        }

        System.out.println(sb);

        
    }



}
