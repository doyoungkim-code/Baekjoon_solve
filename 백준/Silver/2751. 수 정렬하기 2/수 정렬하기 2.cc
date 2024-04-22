#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b);

int main(void)
{
	int num, i, ns;
	int* arr;

	scanf("%d", &num);

	arr = (int*)malloc((sizeof(int) * num));
	i = 0;
	while (i < num)
	{
		scanf("%d", &ns);
		arr[i] = ns;
		i++;
	}
	qsort(arr, num, sizeof(int), compare);
	i = 0;
	while (i < num)
	{
		printf("%d\n", arr[i]);
		i++;
	}
}

int compare(const void* a, const void* b)
{
	int num1 = *(int*)a;
	int num2 = *(int*)b;
	if (num1 < num2)
		return -1;
	if (num1 > num2)
		return 1;
	return 0;
}