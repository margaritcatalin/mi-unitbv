#pragma once
#include"Points.h"
class Punct2d :public Points {
public:
	Punct2d();
	Punct2d(int p,int z);
	~Punct2d();
	int getCoordx();
	int getCoordy();
	void afisare();
	int getCadran();
};