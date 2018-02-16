#include<stdio.h>
void main()
{
	int n, a[100], i, j, max, nr, val;
	scanf_s("%d", &n);
	for (i = 0; i<n; i++)
		scanf_s("%d", &a[i]);
	max = 0;
	for (i = 0; i<n - 1; i++)
	{
		nr = 1;
		for (j = i + 1; j<n; j++)
			if (a[j] == a[i]) nr++;
		if (nr>max)
		{
			max = nr;
			val = a[i];
		}
	}
	printf("%d apare de %d ori ", val, max);

}