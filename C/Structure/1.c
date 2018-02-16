#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<malloc.h>
#include<math.h>
#include<conio.h>
struct dreptungi
{
	float lun;
	float latime;
};
FILE *f, *g;
void citire(struct dreptungi *a,int i)
{
		fscanf(f,"%f%f", &a[i].lun, &a[i].latime);
}
void afisare(struct dreptungi *a,int i)
{
	fprintf(g,"%f %f\n", a[i].lun, a[i].latime);
}
double diagonala(struct dreptungi *a,int i)
{
	double diag;
	diag = sqrt(a[i].lun*a[i].lun + a[i].latime*a[i].latime);
	return diag;
}
float perimetru(struct dreptungi *a,int i)
{
	return 2*a[i].lun+2*a[i].latime;
}
float aria(struct dreptungi *a,int i)
{
	return a[i].lun*a[i].latime;
}
void main()
{
	struct dreptungi *a;
	int i,n;
	f = fopen("dreptungi.txt", "r");
	if (!f)
	{
		printf("Nu exista fisierul!");
	}
	else
	{
		fscanf(f, "%d", &n);
		printf("%d",n);
		a = (struct dreptungi*)malloc(n * sizeof(struct dreptungi));
		for (i = 0; i < n; i++)
			citire(a, i);
		g = fopen("dreptOut.txt", "w");
		for (i = 0; i < n; i++)
		{
			afisare(a, i);
			fprintf(g, "%lf %f %f\n", diagonala(a, i), aria(a, i), perimetru(a, i));
		}
		free(a);
	}
	fclose(f);
	fclose(g);
	_getch();
}