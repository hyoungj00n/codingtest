import sys
N = int(sys.stdin.readline())

road = list(map(int, input().split()))
oil = list(map(int, input().split()))

result = 0
cost = oil[0]
for i in range(len(road)):
    if cost > oil[i]:
        cost = oil[i]
    result += cost * road[i]


print(result)