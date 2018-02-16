#include<stdio.h>
int pivot(int *a, int p, int q)
{
	int i, j, sens, aux;
	i = p;
	j = q;
	sens = 1;
	while (i<j)
	{
		if (a[i]>a[j])
		{
			aux = a[i];
			a[i] = a[j];
			a[j] = aux;
		}
		if (sens == 1)
			i = i + 1;
		else
			j = j - 1;
	}
	return j;
}
void Quick_Sort(int *a, int p, int q)
{
	if (p<q)
	{
		int r;
		r = pivot(a, p, q);
		Quick_Sort(a, p, r - 1);
		Quick_Sort(a, r + 1, q);
	}
}
void main()
{
	int a[100], n, i;
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		scanf_s("%d", &a[i]);
	Quick_Sort(a, 1, n);
	for (i = 1; i <= n; i++)
		printf("%d ", a[i]);
}