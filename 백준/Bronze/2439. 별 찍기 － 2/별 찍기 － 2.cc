#include <stdio.h>

int main(void)
{
	int num;
	int j = 0;
	int i = 0;
	scanf("%d", &num);
	while (j < num)
	{
		i = 0;
		while (i < num - j - 1)
		{
			printf(" ");
			i++;
		}
		while (i < num)
		{
			printf("*");
			i++;
		}
		printf("\n");
		j++;
	}
	return (0);
}