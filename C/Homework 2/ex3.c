#include <stdio.h>

int main()
{
	unsigned i, n;
	int *arr = (int*)malloc(10 * sizeof(int));//declararea unui vector prin alocare dinamica de memorie
	printf_s("Dati valoarea lui n:");
	scanf_s("%u", &n);
	for (i = 0; i <=n-1; i++)
	{
		printf_s("arr[%u]=", i);
		scanf_s("%d", arr+i);//citire pe adresa arr+i
		printf_s("\n");
	}
	printf_s("Numerele pare din vector sunt:\n");
	for (i = 0; i <= n - 1; i++)
		if (*(arr + i) % 2 == 0)//verifica valoarea aflata pe adresa arr+i daca este para
		{
			printf_s("arr[%u]=%d", i, *(arr + i)); //afiseaza valoarea de la adresa arr+i
			printf_s("\n");
		}
	getch();
	return 0;
}
