#include"Nod.h"
Nod::Nod()
{
	this->stanga = NULL;
	this->dreapta = NULL;
}
Nod::~Nod() 
{
	//cout<<"s-a distrus";
}
Nod Nod::operator =(Nod *n) {
	this->data = n->data;
	this->stanga = n->stanga;
	this->dreapta = n->dreapta;
	return (*this);
}
Nod* Nod::getStanga()
{
	return this->stanga;
}
Nod* Nod::getDreapta()
{
	return this->dreapta;

}
int Nod::getData()
{
	return this->data;
}
void Nod::setStanga(Nod* a)
{
	this->stanga=a;
}
void Nod::setDreapta(Nod* a)
{
	this->dreapta=a;

}
void Nod::setData(int a)
{
	this->data=a;
}