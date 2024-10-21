import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] state = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int people = Integer.parseInt(br.readLine());
        int[][] students = new int[people][2];

        for(int i = 0; i < people; i++){
            st = new StringTokenizer(br.readLine());
            students[i][0] = Integer.parseInt(st.nextToken());
            students[i][1] = Integer.parseInt(st.nextToken());
        }



        int order;
        for(int[] student : students){
            order = student[1];


            if(student[0] == 1){
                for (int i = order; i <= n; i += order) {
                    state[i - 1] = 1 - state[i - 1];
                }

            }else{
                int left = order - 1;
                int right = order - 1;


                state[order - 1] = 1 - state[order - 1];


                while (left > 0 && right < n - 1 && state[left - 1] == state[right + 1]) {
                    left--;
                    right++;
                    state[left] = 1 - state[left];
                    state[right] = 1 - state[right];
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < state.length; i++) {
            sb.append(state[i] + " ");
            if ((i + 1) % 20 == 0)
                sb.append("\n");
        }
        System.out.println(sb);


    }


}
