#include <stdio.h>

int main() {
	int a = 0xAF; // 10101111
	int b = 0xB5; // 10110101

	printf("%x \n", a & b);

	return 0;
}