//#include<stdio.h>
//#include<malloc.h>
//#include<conio.h>
//int cod(int nr)
//{
//	int d;
//	d = nr % 10;
//	nr /= 10;
//	while (nr)
//	{
//		if (d <= nr % 10)
//			return 0;
//		else
//		{
//			d = nr % 10;
//			nr /= 10;
//		}
//	}
//	return 1;
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
//	for (i = 0; i < n; i++)
//	{
//		if (cod(v[i]))
//		{
//			printf_s("Primul numar este %d", v[i]);
//			break;
//		}
//	}
//	printf_s("\n");
//	for (i = n-1; i >0; i--)
//	{
//		if (cod(v[i]))
//		{
//			printf_s("Ultimul numar numar este %d", v[i]);
//			break;
//		}
//	}
//	_getch();
//	free(v);
//}