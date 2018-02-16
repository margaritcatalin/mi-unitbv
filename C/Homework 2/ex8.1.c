#include <stdio.h>
int main()
{
	int a = 1, *pa;
	char b = 'b', *pb;
	double c = 1.23, *pc;
	pa = &a;
	pb = &b;
	pc = &c;
	printf_s("Adresa intregului este: 0x%x \n", pa);
	printf_s("Adresa caracterului este: 0x%x \n", pb);
	printf_s("Adresa lui double este: 0x%x \n ", pc);
	printf_s("Adresa pointerului intregului este: 0x%x \n", &pa);
	printf_s("Adresa pointerului caracterului este: 0x%x \n", &pb);
	printf_s("Adresa pointerului catre double este: 0x%x \n", &pc);
	printf_s("\n");
	printf_s("Valoarea intregului este: %d \n", a);
	printf_s("Valoarea caracterului este: %c \n", b);
	printf_s("Valoarea lui double este %1.3lf \n", c);
	printf_s("Valoarea pointerului intregului este: 0x%x\n", *pa);
	printf_s("Valoarea pointerului caracterului este: 0x%x\n", *pb);
	printf_s("Valoarea pointerului catre double este: 0x%x\n", *pc);
	printf_s("\n");
	printf_s("size of int: %d\n", sizeof(a));
	printf_s("size of char: %d\n", sizeof(b));
	printf_s("size of double: %d\n", sizeof(c));
	printf_s("size of *int: %d\n", sizeof(*pa));
	printf_s("size of *char: %d\n", sizeof(*pb));
	printf_s("size of *double: %d\n", sizeof(*pc));
	printf_s("\n");
	getch();
	return 0;
}