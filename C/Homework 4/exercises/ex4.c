#include<stdio.h>
#include<stdio.h>
void inter(int *a, int *b)
{
	int aux;
	aux = *a;
	*a = *b;
	*b = aux;
}
void main()
{
	int a, b, c;
	printf_s("Introduceti valoarea lui a:");
	scanf_s("%d", &a);
	printf_s("Introduceti valoarea lui b:");
	scanf_s("%d", &b);
	printf_s("Introduceti valoarea lui c:");
	scanf_s("%d", &c);
	inter(&a, &b);
	inter(&a, &c);
	printf_s("a=%d,b=%d,c=%d", a, b, c);
	getch();
}
