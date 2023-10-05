import sys
N = int(sys.stdin.readline())
dp = [0]
turn = 'SK'
for i in range(1,N+1):
	if i % 2 != 0:
		turn = 'SK'
	else:
		turn = 'CY'
	if i - 1 == 0 or i - 3 == 0:
		dp.append(turn)
	else:
		dp.append(turn)
print(dp[N])