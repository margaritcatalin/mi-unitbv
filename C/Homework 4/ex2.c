//#include<stdio.h>
//#include<malloc.h>
//#include<conio.h>
//int cautare(int *v, int count)
//{
//	int cifra = 0, i = 0, d;
//	while (i <= count)
//	{
//		d = *(v + i);
//		while (d)
//		{
//			if (cifra < d % 10)
//				cifra = d % 10;
//			d /= 10;
//
//		}
//		i++;
//	}
//	return cifra;
//}
//void main()
//{
//	int *v;
//	int n, i;
//	printf_s("Introduceti cate valori are vectorul:");
//	scanf_s("%d", &n);
//	v = (int*)malloc(n * sizeof(int));
//	for (i = 0; i < n; i++)
//	{
//		printf_s("V[%d]=", i);
//		scanf_s("%d", (v + i));
//	}
//	printf_s("Cifra maxima este: %d\n", cautare(v, n));
//	printf_s("Pozitiile sunt:");
//	for (i = 0; i < n; i++)
//	{
//		if (*(v + i) == cautare(v, n))
//			printf_s("%d,", i);
//	}
//	_getch();
//	free(v);
//}