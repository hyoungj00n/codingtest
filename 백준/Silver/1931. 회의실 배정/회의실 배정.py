import sys

input = sys.stdin.readline

N = int(input())

list = []
for i in range(N):
    X, Y = map(int, input().split())
    list.append([X, Y])
list.sort(key=lambda x: x[0])
list.sort(key=lambda x: x[1])

count = 1
end = list[0][1]

for i in range(1, N):
    if end <= list[i][0]:
        count += 1
        end = list[i][1]
print(count)