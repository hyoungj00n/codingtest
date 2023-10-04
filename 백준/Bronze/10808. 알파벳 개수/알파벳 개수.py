name = input()

al_list = [0]*26

for i in name:
    index = ord(i)-97
    al_list[index]+=1

for i in range(26):
    print(al_list[i])