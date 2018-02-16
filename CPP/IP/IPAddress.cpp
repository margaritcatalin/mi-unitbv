#include "IPAddress.h"

istream& operator >> (istream & flux, IP_Address & ip)
{
	char *s=new char[15],*p,*pp=NULL;
	int i = 0, *l = new int[4];
	flux >> s;
	p = strtok_s(s, ".",&pp);
	while (p) {
		int x = atoi(p);
		if (x >= 0 && x <= 255)
			l[i++] = x;
		else {
			return flux;
		}
		p = strtok_s(NULL, ".",&pp);
		
	}
	ip.x1 = l[0];
	ip.x2 = l[1];
	ip.x3 = l[2];
	ip.x4 = l[3];
	return flux;
}

ostream& operator << (ostream& flux, IP_Address ip)
{
	flux << ip.x1 << "." << ip.x2 << "." << ip.x3 << "." << ip.x4 << "\n";
	return flux;
}

IP_Address::IP_Address()
{
	x1 = x2 = x3 = x4 = -1;
}

IP_Address::IP_Address(int i1, int i2, int i3, int i4)
{
	x1 = i1;
	x2 = i2;
	x3 = i3;
	x4 = i4;
}

IP_Address::~IP_Address()
{
	cout << "End!\n";
}

void IP_Address::set_ip(int i1, int i2, int i3, int i4)
{
	x1 = i1;
	x2 = i2;
	x3 = i3;
	x4 = i4;
}

int IP_Address::get_x1()
{
	return x1;
}

int IP_Address::get_x2()
{
	return x2;
}

int IP_Address::get_x3()
{
	return x3;
}

int IP_Address::get_x4()
{
	return x4;
}
