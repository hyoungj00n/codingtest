def solution(s):
    answer = True
    stack = []
    for i in s:
        if i == ')':
            if not stack:
                answer = False
                break
            stack.pop()
            continue
        stack.append(i)
                
        
    if stack :
        answer = False

    return answer