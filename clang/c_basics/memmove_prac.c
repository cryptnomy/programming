#include <stdio.h>
#include <string.h>

int main() {
    char str[50] = "I love chewing C hahaha";

    printf("%s\n", str);
    printf("After memmove\n");
    memmove(str + 23, str + 17, 6);
    printf("%s", str);

    return 0;
}