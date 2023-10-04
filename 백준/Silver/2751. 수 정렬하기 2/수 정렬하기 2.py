n = int(input())
new_list = []

for i in range(n):

    new_list.append(int(input()))

new_list.sort()

for i in range(len(new_list)):
    print(new_list[i])