n = int(input())
num_list = []

for i in range(n):
    num_list.append(int(input()))


def test(num):

    if num == 1:
        return 1
    if num == 2:
        return 2
    if num == 3:
        return 4
    return  test(num-1) + test(num-2) + test(num-3)

for i in range(len(num_list)):
    print(test(num_list[i]))