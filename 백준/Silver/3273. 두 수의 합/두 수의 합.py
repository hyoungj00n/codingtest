import sys

input = sys.stdin.readline

N = int(input())
list1 = list(map(int, input().split()))

M = int(input())

list1.sort()

start = 0
end = len(list1)-1
count = 0
while start< end:

    if list1[start]+list1[end] == M:
        count += 1
        end -= 1
        start += 1
    elif list1[start]+list1[end] > M:
        end -= 1
    else:
        start += 1

print(count)