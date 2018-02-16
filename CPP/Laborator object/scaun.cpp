#define _CRT_SECURE_NO_WARNINGS
#include "Scaun.h"
Scaun::Scaun()
{
}

Scaun::Scaun(int nrP, char* spat) :Laborator("Scaun")//polimorfism
{
	this->nrPicioare = nrP;
	this->spatar = new char[4];
	strcpy(this->spatar, spat);
}

Scaun::~Scaun()
{
	delete[]this->spatar;
}

void Scaun::afisare()//virtual
{
	std::cout << "\nScaunul cu " << nrPicioare;
	if(strcmp(this->spatar,"Da")==0|| strcmp(this->spatar, "da") == 0)
		std::cout << " are spatar.";
	else
		std::cout << " nu are spatar.";
}

int Scaun::getnrPicioare()//abstractizare
{
	return this->nrPicioare;
}

char* Scaun::getSpatar()
{
	return this->spatar;
}
