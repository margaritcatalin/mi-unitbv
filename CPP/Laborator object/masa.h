#pragma once
#include"Laborator.h"
class Masa:public Laborator{
protected:
	int nrPicioare, dimensiune;
public:
	Masa();
	Masa(int nrP, int dim);
	~Masa();
	void afisare();
	int getNrPicioare();
	int getDimensiune();
};