import sys

n = int(sys.stdin.readline())
num_list =list(map(int,(sys.stdin.readline().split())))
count = [1]* n


for i in range(1,n):
    max_num = 0
    for j in range(i):
        if num_list[i]>num_list[j]:
            if max_num < count[j]:
                max_num = count[j]
    count[i] += max_num
print(max(count))