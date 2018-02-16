#include <stdio.h>
void foo1(int xval)
{
	int x;
	x = xval;
	printf_s("Adresa lui x: %p\n", &x);
	printf_s("x= %d\n", x);
}
void foo2(int dummy)
{
	int y;//y nu a primit o valoarea
	//y = dummy;
	printf("Adresa lui y: %p \n", &y);
	printf_s("y= %d \n", y);
}
int main()
{
	foo1(7);
	foo2(11);
	getch();
	return 0;
}
