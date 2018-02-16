#include <stdio.h>
int j, k;
int *ptr;
int main(void)
{
	j = 1;
	k = 2;
	ptr = &k;
	printf("\n");
	printf("j are valoarea %d si este depozitat pe adresa %p\n", j, (void *)&j);
	printf("k are valoarea %d si este depozitat pe adresa %p\n", k, (void *)&k);
	printf("ptr are valoarea %p si este depozitat pe adresa %p\n", ptr, (void *)&ptr);
	printf("Valoarea de tip intreg indicata de PTR este %d\n", *ptr);
	getch();
	return 0;
}