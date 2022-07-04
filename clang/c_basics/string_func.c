#include <stdio.h>

int copy_str(char *dest, char *src);
int append_str(char *dest, char *src);

int main() {
    char str1[] = "hello";
    char str2[] = "hi";

    printf("Before copy: %s\n", str1);
    copy_str(str1, str2);
    printf("After copy: %s\n", str1);

    return 0;
}
// very risky function since it does not check if destination word length is shorter than that of the source.
int copy_str(char *dest, char *src) {
    while (*src) {
        *dest = *src;
        src++;
        dest++;
    }
    *dest = '\0';
    
    return 1;
}
// this function also seems risky
int append_str(char *dest, char *src) {
    while (*dest) {
        dest++;
    }
    while (*src) {
        *dest = *src;
        src++;
        dest++;
    }
    *dest = '\0';
    return 1;
}