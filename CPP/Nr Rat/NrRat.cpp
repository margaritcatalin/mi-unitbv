#include"NrRat.h"
int NrRat::cmmdc(int x, int y)
{
	x = abs(x);
	y = abs(y);
	while (x != y)
		if (x>y)
			x -= y; //x=x-y;
		else
			y -= x; //y=y-x;
	return x;
}

/*determinarea unei fractii ireductibile*/
void NrRat::ireductibil()
{
	if (a == 0) b = 1;
	else
	{
		if ((abs(a) != 1) && (abs(b) != 1))
		{
			int d;
			d = cmmdc(a, b);
			a /= d; //a=a/d;
			b /= d; //b=b/d;
		}
		if (b<0)
		{
			a = -a;
			b = -b;
		}
	}
}

/*constructor de initializare cu parametri*/
inline NrRat::NrRat(int x, int y)
{
	a = x;
	b = y;
	ireductibil();
}

/*functie ce returneaza numaratorul fractiei*/
inline int& NrRat::retnumarator()
{
	return a;
}

/*functie ce returneaza numitorul fractiei*/
inline int& NrRat::retnumitor()
{
	return b;
}

/*supraincarcarea operatorului de extragere
din flux pentru citirea unui numar NrRat*/

istream& operator >> (istream& in, NrRat& r)
{
	cout << "\tintroduceti numaratorul: ";
	in >> r.a;
	do {
		cout << "\tintroduceti numitorul: ";
		in >> r.b;
	} while (r.b == 0); //numitorul diferit de 0
	r.ireductibil();
	return in;
}

/*supraincarcarea operatorului de insertie in flux
pentru afisarea unui numar NrRat*/

ostream& operator<<(ostream& out, NrRat r)
{
	out << r.a << "/" << r.b;
	return out;
}

/*supraincarcarea operatorului '+' pentru adunarea a doua numere NrRate*/
NrRat NrRat::operator+(NrRat& r)
{
	NrRat p;
	p.a = a*r.b + b*r.a;
	p.b = b*r.b;
	p.ireductibil();
	return p;
}

/*supraincarcarea operatorului '-' pentru determinarea opusului unui numar NrRat*/
NrRat NrRat::operator-()
{
	NrRat p;
	p.a = -a;
	p.b = -b;
	p.ireductibil(); /*la prima vedere pare inutil aici al acestei functii, dar,
					 am optat pentru asta mizand faptul ca nu cunoastem operatiile de populare a
					 datelor unui numar NrRat, daca prin intermediul acestora s-a apelat
					 procedura de determinare a unei fractii ireductibile*/
	return p;
}

/*supraiuncarcarea operatorului '-' pentru diferenta a doua numare NrRate*/
NrRat NrRat::operator-(NrRat& r)
{
	NrRat p;
	p = (*this) + (-r); //apel al celor doua functii definite anterior
	p.ireductibil();
	return p;
}

/*supraincarcarea operatorului '*' pentru inmultirea a doua numere NrRate*/
NrRat NrRat::operator*(NrRat& r)
{
	NrRat p;
	p.a = a*r.a;
	p.b = b*r.b;
	p.ireductibil();
	return p;
}

/*supraincarcarea operatorului '*' pentru inmultirea unui nr. NrRat
cu un numar intreg*/
NrRat NrRat::operator*(int x)
{
	NrRat p;
	p.a = a*x; //sau: x*a;
	p.b = b*x; //sau: x*b;
	p.ireductibil();
	return p;
}

/*supraincarcarea operatorului '*' pentru inmultirea unui numar intreg
cu unul NrRat*/
NrRat operator*(int x, NrRat r)
{
	return r*x; //apel al functiei dezvoltate anterior
}

/*supraincarcarea operatorului '!' pentru inversul unui numar NrRat*/
NrRat NrRat::operator!()
{
	NrRat p;
	p.a = b;
	p.b = a;
	p.ireductibil();
	return p;
}

/*supraincarcarea operatorlui '/' pentru impartirea a doua numere NrRate*/
NrRat NrRat::operator/(NrRat& r)
{
	NrRat p;
	p = (*this)*(!r);
	p.ireductibil();
	return p;
}