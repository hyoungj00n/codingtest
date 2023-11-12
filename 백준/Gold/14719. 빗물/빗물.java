import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int[] height = new int[w];
        int result=0;

        for (int i =0; i<w; i++){
            height[i] = sc.nextInt();
        }

        for (int i =1; i< w-1; i++) {
            int left = 0;
            int right = 0;

            for (int j =i; j>=0; j--){
                left = Math.max(left, height[j]);
            }

            for (int j =i; j<w; j++){
                right = Math.max(right,height[j]);
            }
            result += Math.min(left,right)-height[i];

        }


        System.out.println(result);





    }
}
