#include<stdio.h>
#include<stdarg.h>
#include<conio.h>
#include<malloc.h>
int min(int n, ...)
{
	va_list a;
	va_start(a, n);
	int i, mini;
	int *d = (int*)malloc(n * sizeof(int));
	for (i = 0; i < n; i++)
		d[i] = va_arg(a, int);
	mini = d[0];
	for (i = 1; i < n;i++)
	{
		if (mini > d[i])
			mini = d[i];
	}
	va_end(a);
	free(d);
	return mini;
}
int max(int n, ...)
{
	va_list a;
	va_start(a, n);
	int i, max;
	int *d = (int*)malloc(n * sizeof(int));
	for (i = 0; i < n; i++)
	{
		d[i] = va_arg(a, int);
	}
	va_end(a);
	max = d[0];
	for (i = 1; i < n;i++)
		if (max < d[i])
			max = d[i];
	free(d);
	return max;
}
void main()
{
	printf("Minimul este %d\n", min(3, 7, 2, 9));
	printf("Maximul este %d\n", max(3, 7, 2, 9));
	_getch();
}