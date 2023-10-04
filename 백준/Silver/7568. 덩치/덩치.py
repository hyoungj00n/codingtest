n = int(input())

new_list = []
for i in range(n):
    a,b= map(int, input().split())
    new_list.append((a,b))

rank = []

for i in range(n):
    count=1
    for j in range(n):
        if new_list[i][0] < new_list[j][0] and new_list[i][1] <new_list[j][1]:
            count += 1
    rank.append(count)
for i in rank:
    print(i,end=" ")
