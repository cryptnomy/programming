#include <stdio.h>

int main() {
    FILE *fp = fopen("a.txt", "r");
    int size = 0;

    while (fgetc(fp) != EOF) {
        size++;
    }

    printf("File size: %d bytes\n", size);
    fclose(fp);
    return 0;
}