#pragma once
#include"Laborator.h"
class Scaun :public Laborator {
protected:
	int nrPicioare;
	char *spatar;
public:
	Scaun();
	Scaun(int nrP, char* spat);
	~Scaun();
	void afisare();
	int getnrPicioare();
	char* getSpatar();
};