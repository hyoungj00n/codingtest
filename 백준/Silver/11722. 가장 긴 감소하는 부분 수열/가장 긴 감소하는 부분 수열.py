import sys

n = int(sys.stdin.readline().strip())
num_list = [int(x) for x in sys.stdin.readline().split()]
data = [1] * (n)

for i in range(n):
    for j in range(i):
        if num_list[i] < num_list[j]:
            if data[i] < 1 + data[j]:
                data[i] = 1+data[j]

print(max(data))