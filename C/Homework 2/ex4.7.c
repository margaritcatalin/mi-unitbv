#include <stdio.h>
double *maximum(double *a, int size);
int main()
{
	double v[10];
	int i, n;
	printf_s("Introduceti valoarea lui n= ");
	scanf_s("%d", &n);
	for (i = 0; i < n; i++)
	{
		printf_s("\nv[%d]: ", i);
		scanf_s("%lf",&v[i]);
	}
	printf_s("\n");
	printf_s("Maximul din vector este: %4.3lf \n", *maximum(v, n)); 
	printf("Numarul este pe adresa: %p \n", maximum(v, n));
	getch();
	return 0;
}
double *maximum(double *a, int size)
{
	double max = 0, *ptr;
	int i;
	if (size == 0)
		return 0;
	else
	{
		ptr = a;
		for (i = 0; i < size; i++)
			if (*(a + i)>max)
			{
				max = *(a + i);
				ptr = a + i;
			}
	}
	return ptr;
}