#include"Cerc.h"

Cerc::Cerc(float a, float b, float c) : Figura("cerc")//exemplu de polimorfism
{
	this->x = a;
	this->y = b;
	this->R = c;
}
Cerc::~Cerc()
{

}
bool Cerc::operator<(Cerc &c)
{
	if (this->arie() < c.arie())
		return true;
	else
		return false;
}
float Cerc::getY() const
{
	return this->y;
}
float Cerc::getX() const
{
	return this->x;
}
float Cerc::arie()
{
	return R*R*pi;
}
float Cerc::perim()
{
	return (R + R)*pi;
}
void Cerc::afisare()
{
	std::cout << std::endl << "Coordonata x: " << x << ", Coordonata y: " << y << " Raza:" << R << ")";
}