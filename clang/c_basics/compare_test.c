/* compare_test.c */

#include <stdio.h>
#include "str.h"

char compare(char *str1, char *str2);
int main() {
    char str1[20];
    char str2[20];

    printf("Input two sentences whose length is 20 at maximum.\n");
    scanf("%s", str1);
    scanf("%s", str2);

    if (compare(str1, str2)) {
        printf("%s == %s\n", str1, str2);
    }
    else {
        printf("%s != %s\n", str1, str2);
    }
    return 0;
}