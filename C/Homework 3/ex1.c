#include<stdio.h>
void problema1()
{
	double y;
	int x;
	printf_s("Intruduceti variabila de tip int:");
	scanf_s("%d", &x);
	printf_s("\n");
	printf_s("(d) %d\n", x);
	printf_s("(f) %f\n", x);
	printf_s("(lf) %lf\n", x);
	printf_s("(c) %c\n", x);
	printf_s("(x) %x\n", x);
	printf_s("Intruduceti variabila de tip double:");
	scanf_s("%lf", &y);
	printf_s("\n");
	printf_s("(f) %f\n", x);
	printf_s("(lf) %lf\n", x);
	printf_s("(d) %d\n", x);
	printf_s("(e) %e\n", x);
	getch();
}