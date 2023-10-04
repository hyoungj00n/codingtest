from collections import deque
import sys

input = sys.stdin.readline

N = int(input())

for i in range(N):
    M, K = map(int, input().split())
    arr = [0 for _ in range(M)]
    arr[K] = 1
    count = 0
    queue = list(map(int, input().split()))

    while True:

        maxq = max(queue)
        sample = queue.pop(0)
        flag = arr.pop(0)

        if maxq == int(sample):
            count += 1
            if flag == 1:
                print(count)
                break

        else:
            queue.append(sample)
            arr.append(flag)
