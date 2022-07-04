#include <stdio.h>

__inline int squared(int a) {return a * a;}

int main(int argc, char **argv) {
    printf("%d", squared(3));
    return 0;
}
