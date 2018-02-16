#include "Mountain.h"

istream & operator >> (istream & flux, Mountain & m) {
	flux >> m.name;
	flux >> m.nrPeeks;
	flux.get();
	m.P = new Peek[m.nrPeeks];
	for (int i = 0; i < m.nrPeeks; i++)
		flux >> m.P[i];
	return flux;
}

ostream & operator<<(ostream & flux, Mountain m) {
	flux << m.name << ": " << m.nrPeeks << "\n";
	return flux;
}

Mountain::Mountain() {
	nrPeeks = 0;
}

Mountain::~Mountain() {
	//cout << "Deleted!\n";
}

char*  Mountain::getName() {
	return name;
}

int Mountain::get_nrPeeks() {
	return nrPeeks;
}

Peek Mountain::get_Max_H_Peek(){
	return P[0];
}
