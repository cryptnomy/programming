#include <stdio.h>

int main() {
	double celsius;

	printf("The program that converts Celsius to Fahrenheit.\n");
	printf("Input a temperature in Celsius: ");
	scanf_s("%lf", &celsius);
	printf("%f in Celsius is equal to %f in Fahrenheit.\n", celsius, 9 * celsius / 5 + 32);

	return 0;
}