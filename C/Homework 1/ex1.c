#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<malloc.h>
void main()
{
	int *v, min, i,n,nr;
	FILE *f;
	f = fopen("Date.txt", "r");
	if (!f)
	{
		printf_s("Fisierul nu exista!");
	}
	else
	{
		fscanf(f,"%d", &n);
		v = (int*)malloc(n * sizeof(int));
		for (i = 0; i < n; i++)
			fscanf(f, "%d", &v[i]);
		min = v[0];
		nr = 1;
		for(i=1;i<n;i++)
		{
			if (v[i] < min)
			{
				min = v[i];
				nr = 1;
			}
			else
			{
				if (v[i] == min)
				{
					nr++;
				}
			}
		}
		printf_s("Minim:%d Numar de aparitii:%d", min, nr);
		free(v);
	}
	fclose(f);
	getch();
}