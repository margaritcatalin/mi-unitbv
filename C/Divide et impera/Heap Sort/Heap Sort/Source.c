#include<stdio.h>
void siftdown(int *H, int n, int i)
{
	int fiu = i, aux;
	if (2 * i+1 < size && H[fiu]<H[2 * i+1])
		fiu = 2 * i+1;
	if (2 * i + 2 <= n && H[fiu]<H[2 * i + 2])
		fiu = 2 * i + 2;
	if (fiu != i)
	{
		aux = H[i];
		H[i] = H[fiu];
		H[fiu] = aux;
		siftdown(H, n, fiu);
	}
}
void makeheap(int *H, int n)
{
	int i;
	for (i = n / 2; i >= 1; i--)
		siftdown(H, n, i);
}
void HeapSort(int *H, int n)
{
	int i, aux;
	makeheap(H, n);
	for (i = n; i >= 2; i--)
	{
		aux = H[1];
		H[1] = H[i];
		H[i] = aux;
		siftdown(H, i - 1, 1);
	}
}
void main()
{
	int a[100], n, i;
	scanf_s("%d", &n);
	for (i = 1; i <= n; i++)
		scanf_s("%d", &a[i]);
	HeapSort(a, n);
	for (i = 1; i <= n; i++)
		printf("%d ", a[i]);
}