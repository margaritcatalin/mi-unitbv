#include "Mountain.h"
#include <fstream>
#include <algorithm>

int main() {
	ifstream f("data.txt");
	int nrMountains;
	f >> nrMountains;
	Mountain *M = new Mountain[nrMountains];
	for (int i = 0; i < nrMountains; i++) {
		f >> M[i];
	}
	for (int i = 0; i < nrMountains; i++) {
		sort(M[i].P, M[i].P + M[i].get_nrPeeks());
		cout << M[i].getName() << " " << M[i].P[0];
	}
	for (int i = 0; i < nrMountains; i++) {
		int j = 0;
		cout << M[i].getName() << "\n";
		while(M[i].P[j].getH()>2000)
			 cout<<"     " << M[i].P[j++] << "\n";
	}
	return 0;
}

