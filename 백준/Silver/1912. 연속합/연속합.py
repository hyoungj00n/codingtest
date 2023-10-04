import sys

N = int(sys.stdin.readline())

list1 = list(map(int, input().split()))

dynamic = [0] * N
dynamic[0] = list1[0]
for i in range(1, N):
    dynamic[i] = max(list1[i], dynamic[i-1] + list1[i])


print(max(dynamic))
