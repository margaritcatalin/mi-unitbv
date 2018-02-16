#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
class Banca {
private:
	char *Nume;
	double Numerar;
	char *TipCard;
public:
	Banca();
	Banca(char *a, double b, char *c);
	friend std::istream &operator >> (std::istream &flux, Banca &B);
	friend std::ostream &operator <<(std::ostream &flux, Banca B);
	void setNume(char* a);
	void setNumerar(double a);
	void setTipcard(char* a);
	char* getTipcard();
	char* getNume();
	~Banca();

};