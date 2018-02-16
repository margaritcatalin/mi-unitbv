#include<stdio.h>
#include<malloc.h>
#include<conio.h>
void sortare(int n, int *x)
{
	int i, gasit, aux;
	do
	{
		gasit = 0;
		for (i = 0; i<n - 1; i++)
			if (x[i]>x[i + 1])
			{
				aux = x[i];
				x[i] = x[i + 1];
				x[i + 1] = aux;
				gasit = 1;
			}
	} while (gasit);
}
void main()
{
	int *a,*b,*c;
	int n,m, i, j,k;
	printf("Dimensiunea vectorului a=");
	scanf_s("%d", &n);

	a = (int *)malloc(n * sizeof(int));

	for (i = 0; i < n; i++)
	{
		printf("a[%d]=", i);
		scanf_s("%d", &a[i]);
	}
	printf("\nVectorul a este:\n");
	for (i = 0; i < n; i++)
		printf("%d ", a[i]);
	printf("\n");
	printf("Dimensiunea vectorului b=");
	scanf_s("%d", &m);

	b = (int *)malloc(m * sizeof(int));

	for (i = 0; i < m; i++)
	{
		printf("b[%d]=", i);
		scanf_s("%d", &b[i]);
	}
	printf("\nVectorul b este:\n");
	for (i = 0; i < m; i++)
		printf("%d ", b[i]);
	printf("\n");
	sortare(n, a);//sortam sirul a crescator
	sortare(m, b);//sortam sirul b crescator|
	k = 0;
	i = 0;
	j = 0;
	c = (int *)malloc(1*sizeof(int));

	while (i<n && j<m)//interclasare
		if (a[i]<b[j])
		{
			c = (int *)realloc(c,(k+1) * sizeof(int));
			c[k] = a[i];
			i++;
			k++;
		}
		else
		{
			c = (int *)realloc(c,(k + 1) * sizeof(int));
			c[k] = b[j];
			j++;
			k++;
		}
	while (i<n)//daca au mai ramans elemente in a
	{
		c = (int *)realloc(c,(k + 1) * sizeof(int));
		c[k] = a[i];
		i++;
		k++;
	}
	while (j<m)//daca au mai rams elemente in b
	{
		c = (int *)realloc(c,(k + 1) * sizeof(int));
		c[k] = b[j];
		j++;
		k++;
	}
	printf("\nVectorul c este:\n");
	for (i = 0; i < k; i++)
		printf("%d ", c[i]);
	printf("\n");
	free(a);
	free(b);
	free(c);
	_getch();
}
