#include<stdio.h>
#include<malloc.h>
#include<conio.h>
int dimensiune(int x)
{
	int nr = 0;
	while(x)
	{
		nr++;
		x /= 10;
	}
	return nr;
}
void main()
{
	int *a;
	int n, i,j;
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
	for(i=0;i<n;i++)
	{
		int nr = a[i];
		int d = dimensiune(a[i]);
			while (d)
			{
				n++;
				a = (int *)realloc(a, n * sizeof(int));
				d--;
				for (j = n - 1; j > i; j--)
				{
					a[j + 1] = a[j];
				}
				a[i + 1] = a[i] % 10;
				a[i] /= 10;
			}
			a[i] = nr;
			i += dimensiune(a[i]);
	}
			printf("\nVectorul final este:\n");
			for (i = 0; i < n; i++)
				printf("%d ", a[i]);
			printf("\n");
	free(a);
	_getch();
}



