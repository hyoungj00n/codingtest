name = input()

al_list = [-1]*26
count = 0
for i in name:
    index = ord(i)-97
    if al_list[index] != -1:
        count+=1
        continue
    al_list[index] = count
    count += 1

for i in range(26):
    print(al_list[i],end=" ")