import sys

N, K = map(int, sys.stdin.readline().split())
table = list(sys.stdin.readline())
answer = 0
for i in range(len(table)):
    if table[i] == "P":
        for j in range(max(i - K, 0), min(i + K+1, N)):
            if table[j] == "H":
                table[j] = 0
                answer += 1
                break


print(answer)
