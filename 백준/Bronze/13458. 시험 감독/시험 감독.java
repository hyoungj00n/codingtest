import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int room = Integer.parseInt(br.readLine());
        int[] rooms = new int[room];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < room; i++){
            rooms[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int mainSupervision = Integer.parseInt(st.nextToken());
        int subSupervision = Integer.parseInt(st.nextToken());
        long result = 0;

        for(int i = 0; i < room; i++){
            int roomCount = rooms[i];

            roomCount -= mainSupervision;
            result += 1;

            if(roomCount <= 0){
                continue;
            }
            result += roomCount / subSupervision;

            if( roomCount % subSupervision != 0){
                result += 1;
            }
        }
        System.out.println(result);




        
    }
}
