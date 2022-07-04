#include <stdio.h>

typedef struct SENSOR {
    int sensor_flag;
    int data;
} SENSOR;

int main() {
    volatile SENSOR *sensor;
    while (!(sensor->sensor_flag)) { }
    printf("Data: %d\n", sensor->data);
    return 0;
}