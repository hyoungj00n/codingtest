import sys

word = sys.stdin.readline()
lock = ''
for i in range(len(word)):

    if 65 <= ord(word[i]) < 78 or 97 <= ord(word[i]) < 110:
        lock += chr(ord(word[i])+13)
    elif ord(word[i]) > 77 or ord(word[i]) >109:
        lock += chr(ord(word[i])-13)
    else:
        lock += word[i]

print(lock)