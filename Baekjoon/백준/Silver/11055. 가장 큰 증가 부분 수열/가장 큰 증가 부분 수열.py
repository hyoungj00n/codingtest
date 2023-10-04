n = int(input())

num_list = list(map(int, input().split()))

data = [0] * (n+1)

for i in range(n):
    for j in range(i+1):
        if num_list[i]> num_list[j]:
            if data[i+1] < max(data[j+1]+num_list[i],num_list[j]+num_list[i]):
                data[i+1] = max(data[j+1]+num_list[i],num_list[j]+num_list[i])
    data[1]=num_list[0]
print(max(data))