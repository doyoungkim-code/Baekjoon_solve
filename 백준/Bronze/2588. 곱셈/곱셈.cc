#include <stdio.h>

int main(void)
{
	int a;
	int b;
	scanf("%d%d", &a, &b);
	
	printf("%d\n", a * (b % 10));
	printf("%d\n", (a * (b % 100 - b % 10)) / 10);
	printf("%d\n", (a * (b - b % 100)) / 100);
	printf("%d", a * b);
	return (0);
}