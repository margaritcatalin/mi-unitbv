#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
class Jucatori {
private:
	char *Nume;
	int Castigate;
	int Pierdute;
	int Egalitate;
public:
	Jucatori();
	Jucatori(char *a, int b, int c,int d);
	friend std::istream &operator >> (std::istream &flux, Jucatori &J);
	friend std::ostream &operator <<(std::ostream &flux, Jucatori J);
	friend bool operator<(Jucatori n1, Jucatori n2);
	void setNume(char* a);
	void setCastigate(int a);
	void setPierdute(int a);
	void setEgalitate(int a);
	char* getNume();
	int getCastigate();
	int getPierdute();
	int getEgalitate ();
	~Jucatori();

};