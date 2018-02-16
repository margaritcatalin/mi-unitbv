#include<stdio.h>
void main()
{
	int n, a[100], i, poz, nr;
	printf("n=");
	scanf_s("%d", &n);
	for (i = 0; i<n; i++)
		scanf_s("%d", &a[i]);
	printf("Numarul cautat este ?\n");
	scanf_s("%d", &nr);
	poz = -1;
	for (i = 0; i<n; i++)
		if (a[i] == nr)
			poz = i;
	if (poz >= 0) printf("%d este in vector pe pozitia : %d \n", nr, poz + 1);
	else    printf("%d nu apare in vector \n ", nr);
}