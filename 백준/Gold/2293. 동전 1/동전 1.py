import sys


n, k = list(map(int, sys.stdin.readline().split()))
price = [int(sys.stdin.readline()) for _ in range(n)]

dp = [0 for i in range(k + 1)]
dp[0] = 1


for i in price:
    for j in range(i, k + 1):
        if j - i >= 0:
            dp[j] += dp[j - i]

print(dp[k])
