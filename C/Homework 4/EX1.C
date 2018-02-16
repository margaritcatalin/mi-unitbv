#include<stdio.h>
#include<malloc.h>
#include<conio.h>
void main()
{
	float *a;
	int n, i, j;
	printf("Dimensiunea vectorului=");
	scanf_s("%d", &n);

	a = (float *)malloc(n * sizeof(float));

	for (i = 0; i<n; i++)
	{
		printf("a[%d]=", i);
		scanf_s("%f", &a[i]);
	}
	for (i = 0; i<n; i++)
	{
		n++;//marim pentru partea intraga
		a = (float *)realloc(a, n * sizeof(float));
		for (j = n - 1; j >= i; j--)
		{
			a[j + 1] = a[j];
		}
		i++;//pentru a fi pe pozitia cu valoare
		a[i - 1] = (int)a[i];
		n++;//marim pentru partea fractionara
		a = (float *)realloc(a, n * sizeof(float));
		for (j = n - 1; j > i; j--)
		{
			a[j + 1] = a[j];
		}
		float d;
		d = a[i] - (int)a[i];
		while (d > 0 && d <0.9)
			d *= 10;
		a[i + 1] = d;
		i++;//pentru a trece la urmatoarea valoare
	}
	printf("\nRezultatul este:\n");
	for (i = 0; i < n; i++)
		printf("%f ", a[i]);
	printf("\n");
	free(a);
	_getch();
}