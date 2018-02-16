#include<stdio.h>
void main()
{
	int a[100], n, i, S = 0, max;
	printf("n=");
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		scanf_s("%d", &a[i]);
	for (i = 1; i <= n; i++)
		if (a[i]>0) S = S + a[i];
	if (S != 0)
		printf("Suma maxima este %d \n", S);
	else
	{
		max = a[1];
		for (i = 2; i <= n; i++)
			if (max<a[i]) max = a[i];
		printf("Suma maxima este %d \n", max);
	}
}