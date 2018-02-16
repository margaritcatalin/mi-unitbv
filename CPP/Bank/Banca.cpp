#include"Banca.h"
std::istream &operator >> (std::istream &flux, Banca &B)
{
	std::cout << "Introduceti numele bancii:";
	flux.get();
	flux.getline(B.Nume, 50);
	std::cout << "Introduceti fondurile bancii:";
	flux >> B.Numerar;
	std::cout << "Introduceti tipul de card asociat bancii:";
	flux.get();
	flux.getline(B.TipCard, 25);
	return flux;
}
std::ostream &operator<<(std::ostream &flux, Banca B)
{
	flux << "Banca " << B.Nume << " are fondul de " << B.Numerar << "Lei si tipul de card asociat este " << B.TipCard <<'.'<<  std::endl;
	return flux;
}
Banca::Banca(char *a, double b, char *c)
{
	this->Nume = new char[strlen(a) + 1];
	strcpy(this->Nume, a);
	this->Numerar = b;
	this->TipCard = new char[strlen(c) + 1];
	strcpy(this->TipCard, c);
}
Banca::Banca()
{
	this->Nume = new char[7];
	strcpy(this->Nume, "Anonim");
	this->Numerar = 0;
	this->TipCard = new char[7];
	strcpy(this->TipCard, "Anonim");
}
void Banca::setNume(char* a) {
	this->Nume = new char[strlen(a) + 1];
	strcpy(this->Nume, a);
}
void Banca::setNumerar(double a) {
	Numerar = a;
}
void Banca::setTipcard(char* a) {
	this->TipCard = new char[strlen(a) + 1];
	strcpy(this->TipCard, a);
}
char* Banca::getTipcard() {
	return TipCard;
}
char* Banca::getNume() {
	return Nume;
}
Banca::~Banca()
{
/*	delete[] this->Nume;
	delete[] this->TipCard;*/
}