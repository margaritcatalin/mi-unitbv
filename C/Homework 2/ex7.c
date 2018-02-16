#include <stdio.h>
#include<conio.h> 
int *sort(int *a, int size);
void swap(int *p1, int *p2)
{
	int aux;
	aux = *p2;
	*p2 = *p1;
	*p1 = aux;
}
int main()
{
	int v[11], n,i;
	printf_s("Introduceti n: ");
	scanf_s("%d", &n);
	for (i = 0; i < n; i++)
	{
		printf_s("v[%d]: ", i);
		scanf_s("%d", v+i);
	}
	int *ptr=sort(v, n);
	for (i = 0; i < n; i++)
	{
		printf_s(" v[%d]: %d \n", i, *(ptr+i));
	}
	printf_s("\n");
	printf_s("\n");
	getch();
	return 0;
}
int *sort(int *a, int size)
{
	int i, j;
	for (i = 0; i < size-1; i++)
	{
		for (j = i + 1; j < size; j++)
		{
			if (*(a + j)<*(a + i))
				swap((a + i), (a + j));
		}
	}
	return a;
}