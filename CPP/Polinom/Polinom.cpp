#include"Polinom.h"
Polinom::Polinom()
{

}
Polinom::Polinom(int p)
{
	this->grad = p;
	this->data = new double[this->grad+1];
}
std::istream &operator >> (std::istream &flux, Polinom &p)
{
	std::cout << "\nIntroduceti gradul polinomului:";
	flux >> p.grad;
	p.data = new double[p.grad+1];
	std::cout << "\nIntroduceti coeficientii polinomului:";
	for (int i = 0; i < p.grad+1; i++)
	{
		flux >> p.data[i];
	}
	return flux;
}
std::ostream &operator << (std::ostream &flux, const Polinom p)
{
	for (int i = 0; i < p.grad + 1; i++)
	{
		flux << p.data[i]<<"x^"<<p.grad-i;
		if (i != p.grad)
			flux << '+';
	}
	return flux;
}
bool Polinom::operator<(Polinom nr)const
{
	if (getGrad() < nr.getGrad())
		return true;
	else
		return false;
}
Polinom Polinom::operator=(const Polinom nr)
{
	this->grad = nr.grad;
	this->data = new double[nr.grad+1];
	for (int i = 0; i <=nr.grad; i++)
		this->data[i] = nr.data[i];
	return (*this);
}
Polinom Polinom::operator+(Polinom x)
{
	if (this->grad <= x.grad)
	{
		for (int i = this->grad; i >= 0; i--)
			x.data[i+x.grad- this->grad] = this->data[i] + x.data[i + x.grad - this->grad];
		return x;
	}
	else
	{
		for (int i = 0; i <= x.grad; i++)
			this->data[i+this->grad-x.grad] = this->data[i + this->grad - x.grad] + x.data[i];
		return (*this);
	}
}
Polinom::Polinom(const Polinom & ceva)
{
	this->grad = ceva.grad;
	this->data = new double[this->grad+1];
	for (int i = 0; i <=this->grad; i++)
		this->data[i] = ceva.data[i];
}
int Polinom::getGrad()const
{
	return grad;
}
double Polinom::getDataE(int b)const
{
	return data[b];
}

Polinom::~Polinom()
{
	delete[] this->data;
}