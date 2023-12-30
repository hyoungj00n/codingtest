class Solution
{
    public int solution(int n, int A, int B)
    {
        int answer = 0;
        while(n!=1){
            answer += 1;
            int temp = A % 2;
            A = A / 2;
            A += temp;
            
            temp = B % 2;
            B = B / 2;
            B += temp;
            if (A==B){
                return answer;
            }
            n /= 2;
        }

        return answer;
    }
}