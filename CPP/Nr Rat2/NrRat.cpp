#include"NrRat.h"
NrRat::NrRat()
{
	this->numarator = 0;
	this->numitor = 0;
}
NrRat::NrRat(int a,int b)
{
	this->numarator = a;
	this->numitor = b;
}
std::istream &operator >> (std::istream &flux, NrRat &Nr)
{
	flux >> Nr.numarator;
	std::cout << '-' << std::endl;
	flux >> Nr.numitor;
	return flux;
}
std::ostream &operator << (std::ostream &flux, NrRat Nr)
{
	flux << Nr.numarator<<'/'<<Nr.numitor;
	return flux;
}
NrRat NrRat::operator +(NrRat &nr)
{
	NrRat rez;
	rez.numarator = getNumarator()*nr.getNumitor() + getNumitor()*nr.getNumarator();
	rez.numitor = getNumitor() * nr.getNumitor();
	return rez;
}
NrRat NrRat::operator -(NrRat &nr)
{
	NrRat rez;
	rez.numarator = getNumarator()*nr.getNumitor() - getNumitor()*nr.getNumarator();
	rez.numitor = getNumitor() * nr.getNumitor();
	return rez;
}
bool NrRat::operator<(NrRat nr)
{
	if (getNumarator()*nr.getNumitor() < getNumitor()*nr.getNumarator())
		return true;
	else
		return false;
}
NrRat NrRat::operator *(NrRat &nr)
{
	NrRat rez;
	rez.numarator = getNumarator() * nr.getNumarator();
	rez.numitor = getNumitor() * nr.getNumitor();
	return rez;
}
NrRat NrRat::operator!()
{
	NrRat rez;
	rez.numarator = numitor;
	rez.numitor = numarator;
	return rez;
}
NrRat NrRat::operator/(NrRat &nr)
{
	NrRat rez;
	rez = (*this)*(!nr);
	return rez;
}
int NrRat::getNumarator()
{
	return numarator;
}
int NrRat::getNumitor()
{
	return numitor;
}
void NrRat::setNumarator(int a)
{
	this->numarator = a;
}
void NrRat::setNumitor(int a)
{
	this->numitor = a;
}
NrRat::~NrRat()
{
	
}