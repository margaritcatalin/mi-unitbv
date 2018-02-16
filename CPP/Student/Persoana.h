
#include<iostream>
class Persoana {
protected:
	char nume[50];
	char adresa[50];
	int datan;
public:
	Persoana();
	~Persoana();
	Persoana(char* num,char*adresa,int data);
	char *getNume();
	char *getAdresa();
	int getDataN();
};