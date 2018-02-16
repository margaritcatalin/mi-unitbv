#include<stdio.h>
void main()
{
	int n, a[100],b[100], i, j, nr;
	printf("n=");
	scanf_s("%d", &n);
	b[1] = -1;
	j = 1;
	for (i = 0; i<n; i++)
		scanf_s("%d", &a[i]);
	printf("Numarul cautat este ?\n");
	scanf_s("%d", &nr);

	for (i = 0; i<n; i++)
		if (a[i] == nr)
		{
			b[j] = i;
			j++;
		}
	if (b[1] >= 0) printf("%d apare in vector pe pozitiile : \n",nr);
	for (i = 1; i <= j; i++)
		printf("%d ", b[i]);
	else    printf("%d nu apare in vector \n ", nr);
}