#include"Punct2d.h"
Punct2d::Punct2d():Points()
{

}
Punct2d::Punct2d(int p,int z):Points(p,z)
{
}
Punct2d::~Punct2d()
{

}
int Punct2d::getCoordx()
{
	return this->coordx;
}
int Punct2d::getCoordy()
{
	return this->coordy;
}

void Punct2d::afisare()
{
	std::cout<<std::endl << "(" << coordx << "," << coordy << ")";
}
int Punct2d::getCadran()
{
	return cadran();
}