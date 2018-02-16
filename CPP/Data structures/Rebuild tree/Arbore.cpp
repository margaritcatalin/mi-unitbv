#include"Arbore.h"
Arbore::Arbore()
{
	rad = new Nod;
	rad=NULL;
}
Arbore::~Arbore()
{
	//cout << "s-a distrus";
}
Nod* Arbore::getRad()
{
	return this->rad;
}
void Arbore::setRad(Nod* a)
{
	this->rad=a;
}