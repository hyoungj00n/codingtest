
n = int(input())
num_list = []

for i in range(n):
    [a,b] = list(map(int,input().split()))
    num_list.append([a,b])

num_list.sort(key=lambda x: (x[1],x[0]))

for i in range(n):
    print(num_list[i][0],num_list[i][1])