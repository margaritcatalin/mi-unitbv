#pragma once
#include<iostream>
class Points {
protected:	
	int coordx, coordy;
	int cadran()
	{
		if (coordx>0 && coordy>0 || coordx >= 0 && coordy>0 || coordx>0 && coordy >= 0)
			return 1;
		if (coordx<0 && coordy>0 || coordx <= 0 && coordy>0 || coordx<0 && coordy >= 0)
			return 2;
		if (coordx<0 && coordy<0 || coordx <= 0 && coordy<0 || coordx<0 && coordy <= 0)
			return 3;
		if (coordx>0 && coordy<0 || coordx >= 0 && coordy<0 || coordx>0 && coordy <= 0)
			return 4;
		return 0;
	}
public:
	Points();
	Points(int p, int z);
	~Points();
	virtual int getCoordx() = 0;
	virtual int getCoordy() = 0;
	virtual int getCadran() = 0;
	virtual void afisare() = 0;
};