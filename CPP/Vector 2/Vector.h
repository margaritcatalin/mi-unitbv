#include<iostream>
class Vector {
private:
	int n;
	double *a;
public:
	Vector();
	Vector(int p);
	~Vector();
	Vector(const Vector & ceva);
	friend std::istream& operator >> (std::istream &flux, Vector &p);
	friend std::ostream& operator <<(std::ostream &flux, const Vector p);
	double operator!();
	int getDim();
	double getElement(int b);
};