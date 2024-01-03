import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main{

    static int N;

    static int[] A;





    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        A = Stream.of(br.readLine().split(" ")).mapToInt(Integer :: parseInt).toArray();

        Stack<Integer> stack = new Stack<>();



        for(int i = 0; i < N; i++){

            while(!stack.isEmpty() && A[stack.peek()] <A[i]) {
                A[stack.pop()] = A[i];

            }
            stack.push(i);



        }

        while(!stack.isEmpty()){
            A[stack.pop()] = -1;
        }

        for(int i =0; i<N; i++){
            sb.append(A[i]).append(' ');
        }

        System.out.println(sb);



    }

}