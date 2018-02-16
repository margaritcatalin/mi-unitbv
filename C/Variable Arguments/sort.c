#include<stdio.h>
#include<stdarg.h>
#include<conio.h>
#include<malloc.h>
void sort(int n, ...)
{
	va_list l;
	va_start(l, n);
	int i, j;
	int **a = (int**)malloc(n * sizeof(int*));
	if (!a)
	{
		va_end(l);
		return;
	}
	for (i = 0; i < n; i++)
		a[i] = va_arg(l, int*);
	va_end(l);
	for (i = 0; i < n-1; i++)
		for (j = i+1; j < n; j++)
			if (*(a[i]) > *(a[j]))
			{
				aux = *(a[i]);
				*(a[i]) = *(a[j]);
				*(a[j]) = aux;
		}
	free(a);
}
void main()
{
	int x = 7, y = -2, z = 0, t = 1;
	sort(4, &x, &y, &z, &t);

}