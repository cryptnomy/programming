#include <stdio.h>
enum {RED = 5, BLUE, WHITE = 10, BLACK};
int main() {
    int palette = RED;
    switch (palette) {
        case RED:
            printf("palette: RED, %d %d %d %d\n",
                    RED, BLUE, WHITE, BLACK);
            break;
        case BLUE:
            printf("palette: BLUE, %d\n", BLUE);
            break;
        case WHITE:
            printf("palette: WHITE, %d\n", WHITE);
            break;
        case BLACK:
            printf("palette: BLACK, %d\n", BLACK);
            break;
    }
    return 0;
}