N, M = list(map(int, input().split()))

list1 = list(map(int, input().split()))

sum1 = sum(list1[:M])
result = [sum1]
for i in range(N-M):
    sum1 = sum1 - list1[i]+list1[i+M]
    result.append(sum1)


print(max(result))
