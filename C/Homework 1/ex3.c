#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<malloc.h>
#include<conio.h>
void main()
{
	FILE *f;
	int *v, i, n,val,ok,ord;
	f = fopen("Datein.txt", "r");
	if (!f)
	{
		printf_s("Nu exista fisierul!");

	}
	else
	{
		fscanf(f, "%d", &n);
		v = (int*)malloc(n * sizeof(int));
		for (i = 0; i < n; i++)
			fscanf(f, "%d", &v[i]);
		ok = 1;
		if (v[0] < v[1])
		{
			ord = 1;//crescator
		}
		else
		{
			ord = 0;
		}
		if (ord == 1)
		{
			val = v[1];
			for (i = 2; i < n; i++)
				if (v[i] < val)
				{
					ok = 0;
				}
				else
				{
					val = v[i];
				}
		}
		else
		{
			val = v[1];
			for (i = 2; i < n; i++)
				if (v[i] > val)
				{
					ok = 0;
				}
				else
				{
					val = v[i];
				}
		}
		if (ok == 1)
		{
			if (ord == 1)
			{
				printf("Vectorul este ordonat crescator");
			}
			else
			{
				printf("Vectorul este ordonat descrescator");
			}
		}
		else
		{
			printf("Vectorul nu este sortat");
		}
	}
	fclose(f);
	_getch();
}