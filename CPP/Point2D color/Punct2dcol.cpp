#define _CRT_SECURE_NO_WARNINGS
#include"Punct2dcol.h"

Punct2dcol::Punct2dcol():Points()
{

}

Punct2dcol::Punct2dcol(int p,int z, char *c) : Points(p,z)
{
	color = new char[strlen(c)+1];
	strcpy(this->color, c);
}
char* Punct2dcol::getColor()
{
	return this->color;
}

int Punct2dcol::getCoordx()
{
	return this->coordx;
}
int Punct2dcol::getCoordy()
{
	return this->coordy;
}
Punct2dcol::~Punct2dcol()
{
	delete[]this->color;
}

void Punct2dcol::afisare()
{
	std::cout<<std::endl << "(" << coordx << "," << coordy << ")" << "(" << color << ")";
}
int Punct2dcol::getCadran()
{
	return cadran();
}
