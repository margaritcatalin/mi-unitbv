#include"Vectori.h"
std::istream &operator >> (std::istream &flux, Vectori &v)
{
	std::cout << "Introduceti valoarea:";
	flux >> v.data;
	return flux;
}
std::ostream &operator<<(std::ostream &flux, Vectori v)
{
	flux << v.data << std::endl;
	return flux;
}
int Vectori::getPrima()
{
	int x = this->data;
	int a = 0;
	while (x)
	{
		a = a * 10 + x % 10;
	}
	return a % 10;
}
bool operator<(Vectori v1, Vectori v2)
{
	if (v1.data<v2.data)
		return true;
	return false;
}

Vectori::Vectori(int a)
{
	this->data = a;
}
Vectori::Vectori()
{
	this->data = 0;
}
void Vectori::setData(int a) {
	data = a;
}
int Vectori::getData() {
	return data;
}
Vectori::~Vectori()
{

}