def solution(wallpaper):
    answer = []
    j_list =[]
    i_list=[]
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] =='#':
                j_list.append(j)
                i_list.append(i)
                
    answer.append([min(i_list),min(j_list),max(i_list)+1,max(j_list)+1])
    return answer[0]