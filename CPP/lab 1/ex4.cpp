#include<iostream.h>
int dim(unsigned b)
{	
	int nr = 1;
	while (b)
	{
		nr++;
	}
	return nr;
}
void palindrom(unsigned x)
{
	unsigned d;
	while (x)
	{
		d = x % 10;
		x /= 10;
	}
	if (x == d)
		return 1;
	else
		return 0;
}
void main()
{
	unsigned a, b,d;
	cin >> a;
	cin >> b;
	if (palindrom(a) == 1 && palindrom(b) == 1)
	{
		d = a;
		d = d*dim(b) + b;
	}
}