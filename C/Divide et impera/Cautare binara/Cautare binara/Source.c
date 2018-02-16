/* Se da un vector sortat , sa se caute un element x prin metoda cautarii binare */
#include<stdio.h>
void main()
{
	int n, a[100], x, poz, st, dr, m, i;
	printf("n=");
	scanf_s("%d", &n);
	printf("Elementele vectorului sortat sunt: ");
	for (i = 1; i <= n; i++)
		scanf_s("%d", &a[i]);
	printf("x=");
	scanf_s("%d", &x);
	poz = 0;
	st = 1;
	dr = n;
	while ((poz == 0) && (st <= dr))
	{
		m = (st + dr) / 2;
		if (x == a[m])
			poz = m;
		else
			if (x<a[m])
				dr = m - 1;
			else
				st = m + 1;
	}
	if (poz == 0)
		printf("%d nu apare in vector \n", x);
	else
		printf("%d este in vector pe pozitia %d \n", x, poz);
}