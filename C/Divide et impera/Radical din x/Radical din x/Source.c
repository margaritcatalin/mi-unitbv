#include<stdio.h>
double radical(double x, double a, double b, double e)
{
	double m, modul;
	m = (a + b) / 2;
	modul = m*m - x;
	if (modul<0) modul = -modul;
	if (modul<e)
		return m;
	else
		if (m*m>x)
			return radical(x, a, m, e);
		else
			return radical(x, m, b, e);
}
void main()
{
	double x, rad;
	printf("x=");
	scanf_s("%lf", &x);
	rad = radical(x, 0, x, 0.00000001);
	printf("Radical din %lf este %lf \n", x, rad);
}