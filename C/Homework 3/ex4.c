#include<stdio.h>
void gsasd()
{
	unsigned x, nr = 0;
	double s = 0;
	printf_s("Intruduceti variabila de tip natural de minim 6 cifre:");
	scanf_s("%u", &x);
	while (x)
	{
		s += x % 10;
		x /= 10;
		nr++;
	}
	printf_s("Media aritmetica este: %.4lf", s / nr);
	getch();
}