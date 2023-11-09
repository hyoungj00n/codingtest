#include <iostream>

using namespace std;
int N, min_num, max_num;
int num[100];
int add, sub, mul,di;
int flag =1;

void dfs(int i, int result, int add, int sub, int mul, int div){

    if (i== N){
        if (flag==1){
            flag =0;
            min_num = result;
            max_num = result;
        }else{
            min_num = min(result,min_num);
            max_num = max(result,max_num);
        }
        return;
    }
    if (add>0)
        dfs(i+1,result+num[i],add-1,sub,mul,div);
    if (sub>0)
        dfs(i+1,result-num[i],add,sub-1,mul,div);
    if (mul>0)
        dfs(i+1,result*num[i],add,sub,mul-1,div);
    if (div>0)
        dfs(i+1,result/num[i],add,sub,mul,div-1);



}

int main(){


    cin >> N;
    for (int i = 0; i<N; i++){
        cin >> num[i];
    }
    cin >> add >> sub >> mul >> di;

    
    dfs(1,num[0],add,sub,mul,di);

    cout << max_num << "\n" << min_num;
    
    

    return 0;
    
}