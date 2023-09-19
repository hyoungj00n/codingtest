

def solution(keymap, targets):
    answer = []
    
    
    for target in targets:
        count = 0
        
        for i in target:
            flag = False
            mini = 101
            for key in keymap:
                if i in key:
                    mini = min(key.index(i)+1,mini)
                    flag = True
            if not flag:
                count = -1
                break    
            
            
            count += mini
    
        answer.append(count)
                    
            
            
    return answer