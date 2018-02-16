#include "Masa.h"
Masa::Masa()
{
}

Masa::Masa(int nrP, int dim):Laborator("Masa")//polimorfism
{
	this->nrPicioare = nrP;
	this->dimensiune = dim;
}

Masa::~Masa()
{
}

void Masa::afisare()//virtual
{
	std::cout << "\nMasa cu dimensiunea " << dimensiune << " are " << nrPicioare << " picioare.";
}

int Masa::getNrPicioare()//abstractizare
{
	return this->nrPicioare;
}

int Masa::getDimensiune()
{
	return this->dimensiune;
}