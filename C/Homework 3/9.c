#include<stdio.h>
#include<string.h>
void main()
{
	int i, nrc[4];
	char Nume1[50], Nume2[50], Nume3[50], Nume4[50], Prenume1[50], Prenume2[50], Prenume3[50], Prenume4[50], Materia1[50], Materia2[50], Materia3[50], Materia4[50];
	double Nota[4];
	//elevul numarul 1
	printf_s("Introduceti Numele si prenumele elevului:");
	scanf_s("%s", Nume1, sizeof Nume1);
	scanf_s("%s", Prenume1, sizeof Prenume1);
	printf_s("Introduceti materia elevului precedent:");
	scanf_s("%s", Materia1, sizeof Materia1);
	printf_s("Introduceti nota elevului precedent:");
	scanf_s("%lf", &Nota[1]);
	//elevul numarul 2
	printf_s("Introduceti Numele si prenumele elevului:");
	scanf_s("%s", Nume2, sizeof Nume2);
	scanf_s("%s", Prenume2, sizeof Prenume2);
	printf_s("Introduceti materia elevului precedent:");
	scanf_s("%s", Materia2, sizeof Materia2);
	printf_s("Introduceti nota elevului precedent:");
	scanf_s("%lf", &Nota[2]);
	//elevul numarul 3
	printf_s("Introduceti Numele si prenumele elevului:");
	scanf_s("%s", Nume3, sizeof Nume3);
	scanf_s("%s", Prenume3, sizeof Prenume3);
	printf_s("Introduceti materia elevului precedent:");
	scanf_s("%s", Materia3, sizeof Materia3);
	printf_s("Introduceti nota elevului precedent:");
	scanf_s("%lf", &Nota[3]);
	//elevul numarul 4
	printf_s("Introduceti Numele si prenumele elevului:");
	scanf_s("%s", Nume4, sizeof Nume4);
	scanf_s("%s", Prenume4, sizeof Prenume4);
	printf_s("Introduceti materia elevului precedent:");
	scanf_s("%s", Materia4, sizeof Materia4);
	printf_s("Introduceti nota elevului precedent:");
	scanf_s("%lf", &Nota[4]);
	for (i = 1; i <= 4; i++)
		nrc[i] = i;
	printf_s("------------------------------------------------------------------\n");
	printf_s("|   Nr curent   |   Nume si Prenume   |   Materia    |    Nota   |\n");
	printf_s("------------------------------------------------------------------\n");
	printf_s("|       %d       |   %s %s   |   %s    |    %.2lf   |\n", nrc[1], Nume1, Prenume1, Materia1, Nota[1]);
	printf_s("|       %d       |   %s %s   |   %s    |    %.2lf   |\n", nrc[2], Nume2, Prenume2, Materia2, Nota[2]);
	printf_s("|       %d       |   %s %s   |   %s    |    %.2lf   |\n", nrc[3], Nume3, Prenume3, Materia3, Nota[3]);
	printf_s("|       %d       |   %s %s   |   %s    |    %.2lf   |\n", nrc[4], Nume4, Prenume4, Materia4, Nota[4]);
	printf_s("------------------------------------------------------------------\n");

}