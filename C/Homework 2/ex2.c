#include<stdio.h>
void swap(int *p1, int *p2)//2 pointeri la valori intregi
{
	int aux;
	aux = *p1;
	*p1 = *p2;
	*p2 = aux;
}
void main()
{
	int x, y;
	printf_s("Dati valoarea lui x:");
	scanf_s("%d", &x);
	printf_s("\nDati valoarea lui y:");
	scanf_s("%d", &y);
	swap(&x, &y);//transmitere prin adresa deoarece functia se apeleaza prin pointeri(adrese)
	printf_s("\nAcum x= %d si y= %d",x,y);
	getch();
}