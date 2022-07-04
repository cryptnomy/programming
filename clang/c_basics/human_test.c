#include <stdio.h>
#include "human.c"

int main() {
    struct Human Lee = Create_Human("Lee", 40, MALE);
    Print_Human(&Lee);

    return 0;
}