#include<stdio.h>
#include<malloc.h>
#include<conio.h>
int max(int x)
{
	int c,max = 0;//cea mai mica cifra
	while (x)
	{
		c = x % 10;
		if (c > max)
			max = c;
		x /= 10;
	}
	return max;
}
int min(int x)
{
	int c, min = 9;//cea mai mare cifra
	while (x)
	{
		c = x % 10;
		if (c < min)
			min = c;
		x /= 10;
	}
	return min;
}
void main()
{
	int *a;
	int n, i, j;
	printf("Dimensiunea vectorului=");
	scanf_s("%d", &n);

	a = (int *)malloc(n * sizeof(int));

	for (i = 0; i<n; i++)
	{
		printf("a[%d]=", i);
		scanf_s("%d", &a[i]);
	}
	printf("\nVectorul initial este:\n");
	for (i = 0; i < n; i++)
		printf("%d ", a[i]);
	printf("\n");
	for (i = 0; i<n; i++)
	{
			n++;//marim pentru minim
			a = (int *)realloc(a, n * sizeof(int));
			for (j = n - 1; j >= i; j--)
			{
				a[j + 1] = a[j];
			}
			i++;//pentru a fi pe pozitia cu valoare
			a[i-1] = min(a[i]);
			n++;//marim pentru maxim
			a = (int *)realloc(a, n * sizeof(int));
			for (j = n - 1; j > i; j--)
			{
				a[j + 1] = a[j];
			}
			a[i + 1] = max(a[i]);
			i++//pentru a trece la urmatoarea valoare
	}
	printf("\nVectorul final este:\n");
	for (i = 0; i < n; i++)
		printf("%d ", a[i]);
	printf("\n");
	free(a);
	_getch();
}



