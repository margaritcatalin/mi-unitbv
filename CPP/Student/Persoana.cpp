#include"Persoana.h"
#include<string>
Persoana::Persoana()
{
}
Persoana::~Persoana()
{
}
Persoana::Persoana(char* num, char* adr, int data)
{
	strcpy(this->nume, num);
	strcpy(this->adresa, adr);
	this->datan = data;
}
char * Persoana::getNume()
{
	return this->nume;
}
char * Persoana::getAdresa()
{
	return this->adresa;
}
char * Persoana::getDataN()
{
	return this->datan;
}