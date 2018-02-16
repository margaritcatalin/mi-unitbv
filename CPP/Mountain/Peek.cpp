#include "Peek.h"

istream & operator >> (istream & flux, Peek & p) {
	flux>>p.name;
	flux >> p.h;
	flux.get();
	return flux;
}

ostream & operator<<(ostream & flux, Peek p) {
	flux << p.name << ": " << p.h << "\n";
	return flux;
}

Peek::Peek() {
	h = 0;
}

Peek::~Peek() {
	//cout << "Deleted!\n";
}
bool Peek::operator<(Peek p) {
	if (h < p.getH())
		return false;
	return true;
}

char * Peek::getName() {
	return name;
}

int Peek::getH() {
	return h;
}
