import sys

while True:
    new_list = sys.stdin.readline().rstrip("\n")

    if not new_list:
        break
    Upper, Lower, num, space = 0, 0, 0, 0

    for i in range(len(new_list)):
        if ord(new_list[i]) >= 65 and ord(new_list[i]) <= 90:
            Upper += 1
        elif ord(new_list[i]) >= 97 and ord(new_list[i]) <= 122:
            Lower += 1
        elif ord(new_list[i]) >= 48 and ord(new_list[i]) <=57:
            num +=1
        elif new_list[i] == " ":
            space += 1

    print(Lower, Upper, num, space)