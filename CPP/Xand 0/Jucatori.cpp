#include"Jucatori.h"
std::istream &operator >> (std::istream &flux, Jucatori &J)
{
	std::cout << "Introduceti numele jucatorului:";
	flux.get();
	flux.getline(J.Nume, 50);
	return flux;
}
std::ostream &operator<<(std::ostream &flux, Jucatori J)
{
	flux << "Jucatorul " << J.Nume << " are " << J.Castigate<<" meciuri castigate, "<<J.Egalitate<<" meciuri terminate la egalitate si "<<J.Pierdute<<" meciuri pierdute." << std::endl;
	return flux;
}
bool operator<(Jucatori n1, Jucatori n2)
{
	if (n1.getCastigate()<n2.getCastigate())
		return false;
	return true;
}
Jucatori::Jucatori(char *a, int b, int c, int d)
{
	this->Nume = new char[strlen(a) + 1];
	strcpy(this->Nume, a);
	this->Castigate = b;
	this->Egalitate = c;
	this->Pierdute = d;
}
Jucatori::Jucatori()
{
	this->Nume = new char[7];
	strcpy(this->Nume, "Anonim");
	this->Castigate = 0;
	this->Egalitate = 0;
	this->Pierdute = 0;
}
void Jucatori::setNume(char* a) {
	this->Nume = new char[strlen(a) + 1];
	strcpy(this->Nume, a);
}
void Jucatori::setCastigate(int a)
{
	this->Castigate = a;
}
void Jucatori::setPierdute(int a)
{
	this->Pierdute = a;
}
void Jucatori::setEgalitate(int a)
{
	this->Egalitate = a;
}
char* Jucatori::getNume()
{
	return Nume;
}
int Jucatori::getCastigate()
{
	return Castigate;
}
int Jucatori::getPierdute()
{
	return Pierdute;
}
int Jucatori::getEgalitate()
{
	return Egalitate;
}
Jucatori::~Jucatori()
{
	/*	delete[] this->Nume;*/
}