#include"Vector.h"
Vector::Vector()
{
	
}
Vector::Vector(int p)
{
	this->n = p;
	this->a = new double[this->n];
}
std::istream &operator >> (std::istream &flux, Vector &p)
{
	flux >> p.n;
	p.a = new double[p.n];
	for (int i = 0; i < p.n; i++)
	{
		flux >> p.a[i];

	}
	return flux;
}
std::ostream &operator << (std::ostream &flux, const Vector p)
{
	for (int i = 0; i < p.n; i++)
		flux << p.a[i]<<' ';
	return flux;
}
Vector::Vector(const Vector & ceva)
{
	this->n = ceva.n;
	this->a = new double[this->n];
	for (int i = 0; i < n; i++)
		this->a[i] = ceva.a[i];
}
int Vector::getDim()const
{
	return n;
}
double Vector::getElement(int b)const
{
	return a[b];
}
double Vector::operator!()const
{
	double p=0;
	for (int i = 0; i < this->n; i++)
		p += (this->a[i] * this->a[i]);
	return sqrt(p);
}
Vector::~Vector()
{
	delete[] this->a;
}