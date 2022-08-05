#include<stdio.h>
#include<stdlib.h>

int hanoicount(int n){
    
    if (n<2){
    
        return 1;
    }
    else{
       return hanoicount(n-1)*2+1;
    }
    
    
}
void hanoi(int n, int a, int b, int c){
    
	if (n == 1){
		printf("%d %d\n", a, c);
        return;
    }
	else {
		hanoi(n - 1, a, c, b);//가장 큰 원반을 제외한 원반을 a에서 출발해서 c를 거쳐 b에 도착
		printf("%d %d\n", a, c);
		hanoi(n - 1, b, a, c);


	}
}

int main(void){
    
    int n;
    scanf("%d",&n);
    printf("%d\n",hanoicount(n));
    hanoi(n,1,2,3);
}