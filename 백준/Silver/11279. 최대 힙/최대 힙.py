import heapq
import sys

n = int(sys.stdin.readline())
answer = []
heap = []
for i in range(n):
    x = int(sys.stdin.readline())
    if x:
        heapq.heappush(heap, -x)
    else:
        if not heap:
            print(0)
        else:
            print(-heapq.heappop(heap))
