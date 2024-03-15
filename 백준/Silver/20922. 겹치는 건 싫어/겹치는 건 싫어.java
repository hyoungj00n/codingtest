import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    int[] a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++)
      a[i] = Integer.parseInt(st.nextToken());

    int[] cnt = new int[100001]; //배열 안의 값들이 몇 번 나왔는지 계수정렬 식으로 체크
    int s = 0, e = 0, ans = 0; //start, end 투 포인터
    while (true) {
      if (e < n) //end포인터가 가리키는 값을 cnt
        cnt[a[e]]++;

      if (cnt[a[e]] > k) { // k보다 크다면?
        ans = Math.max(ans, e - s); //시작~끝점 갱신 (원래는 0부터 시작해서 +1 해야 하지만 이미 범위를 넘은 상태라 -1을 해야 해서 안해줌)
        while(true) {
          cnt[a[s]]--;
          s++;
          if (cnt[a[e]] == k) break; //현재 카운트된 값이 k개만큼 줄어들때까지 s포인터 앞으로 이동
        }
      }

      if (e < n - 1)
        e++; //e 포인터 이동
      else {
        ans = Math.max(ans, e - s + 1); //e 포인터가 마지막까지 왔다면 현재 s~e값 계산 후 갱신
        break;
      }
    }

    System.out.print(ans);
  }
}