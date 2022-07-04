#include <stdio.h>
int pswap(int **ppa, int **ppb);
int main() {
    int a, b;
    int *pa, *pb;
    pa = &a;
    pb = &b;
    printf("pa: %p\n", pa);
    printf("&pa: %p\n", &pa);
    printf("pb: %p\n", pb);
    printf("&pb: %p\n", &pb);
    
    return 0;
}