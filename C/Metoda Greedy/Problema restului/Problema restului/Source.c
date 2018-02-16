#include<stdio.h>
void sortare(int n, int *a)
{
	int i, j, aux;
	for (i = 1; i<n; i++)
		for (j = i + 1; j <= n; j++)
			if (a[i]<a[j])
			{
				aux = a[i];
				a[i] = a[j];
				a[j] = aux;
			}
}
void main()
{
	int n, monede[50], suma, i, j;
	printf("Suma de plata este: ");
	scanf_s("%d", &suma);
	printf("Numarul de monede diferite este: ");
	scanf_s("%d", &n);
	printf("Valorile monedelor sunt: ");
	for (i = 1; i <= n; i++)
		scanf_s("%d", &monede[i]);
	sortare(n, monede);
	i = 1;
	while (suma != 0)
	{
		if (suma / monede[i]>0)
		{
			for (j = 1; j <= suma / monede[i]; j++)
				printf("%d ", monede[i]);
			suma = suma % monede[i];
		}
		i++;
	}
}