#include<stdio.h>
#include<match.h>
void gigi()
{
	double x;
	printf_s("Intruduceti variabila de tip double:");
	scanf_s("%lf", &x);
	if (x - floor(x)==0)
		printf_s("Da!");
	else
		printf_s("Nu!");
	getch();
}