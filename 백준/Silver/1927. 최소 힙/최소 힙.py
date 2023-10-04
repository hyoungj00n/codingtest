import sys
import heapq

N = int(sys.stdin.readline())
space = []
for i in range(N):
    space.append(int(sys.stdin.readline()))

stack = []


for i in range(N):
    if space[i] == 0:
        if stack:
            print(heapq.heappop(stack))
        else:
            print(0)
        continue
    heapq.heappush(stack, space[i])
