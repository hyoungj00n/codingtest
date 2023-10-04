import sys

word = sys.stdin.readline().rstrip('\n')
word_list = []
n = len(word)

for i in range(n):
    word_list.append(word[i:n])

word_list.sort()

for i in word_list:
    print(i)