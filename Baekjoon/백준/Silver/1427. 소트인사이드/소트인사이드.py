n = int(input())
new_list = list(map(int,str(n)))

new_list.sort(reverse=True)

for i in range(len(new_list)):
    print(new_list[i],end="")


