#include <stdio.h>
int change_val(int* pi) {
    printf("&pi: %p\n", &pi);
    printf("pi: %p\n", pi);
    printf("*pi: %d\n", *pi);
    *pi = 3;
    printf("change_val function ended\n");
    return 0;
}

int main() {
    int i = 0;
    printf("i variable address: %p\n", &i);
    printf("i value before a function call: %d\n", i);
    change_val(&i);
    printf("i value after the funciton call: %d\n", i);
    return 0;
}