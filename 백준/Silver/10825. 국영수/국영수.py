n = int(input())
mem_list = []

for i in range(n):
    [a,b,c,d] = list(map(str,input().split()))
    mem_list.append([a,b,c,d])


mem_list.sort(key=lambda x: (-int(x[1]),int(x[2]), -int(x[3]),x[0]))



for i in range(n):
    print(mem_list[i][0])