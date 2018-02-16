#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<malloc.h>
#include<conio.h>
void main()
{
	unsigned *v,nr,nra,nrt=0,i, j, n;
	FILE *f;
	f = fopen("data.txt", "r");
	if (!f)
	{
		printf_s("Fisierul nu exista!");
	}
	else
	{
		fscanf(f, "%u", &n);
		v = (unsigned*)malloc(n * sizeof(unsigned));
		for (i = 0; i<n; i++)
			fscanf(f, "%u", &v[i]);
		for (i = 0; i<n; i++)
		{
			nra = 0;
			for (j = 0; j < n; j++)
			{

				if (v[j] == v[i])
					nra++;
			}
			if (nra > nrt)
			{
				nrt = nra;
				nr = v[i];
			}
		}
		printf_s("Numarul:%u Numar de aparitii:%u", nr, nrt);
		free(v);
	}
	fclose(f);
	_getch();
}