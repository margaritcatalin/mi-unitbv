#include<stdio.h>
int vx[10], vy[10], labirint[100][100], n, m, xA, yA, xR, yR, nr = 0;
int valid(int x, int y, int c)
{
	if (x + vx[c]<1)
		return 0;
	if (x + vx[c]>n)
		return 0;
	if (y + vy[c]<1)
		return 0;
	if (y + vy[c]>m)
		return 0;
	if (labirint[x + vx[c]][y + vy[c]] != 0)
		return 0;

	return 1;

}
int solutie(int x, int y, int k)
{
	if (labirint[xR][yR] == 0) return 0;
	if ((x == xA) && (y == yA)) return 1;
	return 0;
}
void afisare()
{

	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= m; j++)
		{
			if ((i == xA) && (j == yA)) printf("A ");
			else
				if ((i == xR) && (j == yR)) printf("R ");
				else printf("%d ", labirint[i][j]);
		}
		printf("\n");
	}
	printf("\n");

}
void back(int x, int y, int k)
{
	for (int c = 1; c <= 8; c++)
		if (valid(x, y, c) == 1)
		{
			labirint[x + vx[c]][y + vy[c]] = k;
			if ((x + vx[c] == xR) && (y + vy[c] == yR))
				back(x + vx[c], y + vy[c], k);
			else
				if (solutie(x + vx[c], y + vy[c], k) == 1) afisare();
				else back(x + vx[c], y + vy[c], k + 1);

				labirint[x + vx[c]][y + vy[c]] = 0;
		}
}
void main()
{

	printf("n=");
	scanf_s("%d", &n);
	printf("m=");
	scanf_s("%d", &m);
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= m; j++)
			scanf_s("%d", &labirint[i][j]);

	printf("Coordonatele lui Atilo :");
	scanf_s("%d %d", &xA, &yA);

	printf("Coordonatele Regelui :");
	scanf_s("%d %d", &xR, &yR);
	vx[0] = 0;
	vx[1] = -2;
	vx[2] = -2;
	vx[3] = -1;
	vx[4] = 1;
	vx[5] = 2;
	vx[6] = 2;
	vx[7] = 1;
	vx[8] = -1;

	vy[0] = 0;
	vy[1] = -1;
	vy[2] = 1;
	vy[3] = 2;
	vy[4] = 2;
	vy[5] = 1;
	vy[6] = -1;
	vy[7] = -2;
	vy[8] = -2;

	back(xA, yA, 1);
	printf("terminare program");
	int i;
	scanf_s("%d", &i);
}