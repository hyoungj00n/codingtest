import sys
import math
from collections import Counter
N = int(input())

list = []

for i in range(N):
    list.append(int(input()))

list.sort()
avg = round(sum(list) / N)
middle = list[math.floor(N/2)]
count = Counter(list).most_common()
best = count
range = max(list)-min(list)
print(avg)
print(middle)
if len(count) > 1 and count[0][1] == count[1][1]:
    print(count[1][0])
else:
    print(count[0][0])
print(range)
