#include<stdio.h>
#include<malloc.h>
#include<conio.h>
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
		int nr = a[i];
		int pas = 0;
		while (a[i])
		{
				n++;
				a = (int *)realloc(a, n * sizeof(int));
				for (j = n - 1; j > i; j--)
				{
					a[j + 1] = a[j];
				}
				a[i + 1] = 0;
				a[i] /= 10;
				pas++;
		}
		a[i] = nr;
		i += pas;
	}
	printf("\nVectorul final este:\n");
	for (i = 0; i < n; i++)
		printf("%d ", a[i]);
	printf("\n");
	free(a);
	_getch();
}



