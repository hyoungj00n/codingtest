import sys

word = sys.stdin.readline()
count = 0

for i in range(len(word)-1):
    if word == "\n":
        break
    count +=1
print(count)