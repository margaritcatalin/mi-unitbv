#pragma once
#include "Points.h"
class Punct2dcol :public Points {
public:
	char *color;
	Punct2dcol();
	Punct2dcol(int p, int z,char *c);
	char* getColor();
	int getCoordx();
	int getCoordy();
	~Punct2dcol();
	void afisare();
	int getCadran();
};