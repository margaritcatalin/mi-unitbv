#include<stdio.h>
void main()
{
	int n, i, j, key, a[100];
	printf("n=");
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		scanf_s("%d", &a[i]);
	for (j = 2; j <= n; j++)
	{
		key = a[j];
		i = j - 1;
		while (i>0 && a[i]>key)
		{
			a[i + 1] = a[i];
			i = i - 1;
		}
		a[i + 1] = key;
	}
	for (i = 1; i <= n; i++)
		printf("%d ", a[i]);
}