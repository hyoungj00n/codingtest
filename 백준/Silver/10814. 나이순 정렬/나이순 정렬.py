n = int(input())
mem_list = []
for i in range(n):
    [a,b] = list(map(str,input().split()))
    mem_list.append([a,b])

mem_list.sort(key = lambda x:int(x[0]))

for i in range(n):
    print(mem_list[i][0],mem_list[i][1])