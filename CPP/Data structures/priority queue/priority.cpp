#include"priority.h"
priority::priority(int n)
{
	H = new int[n];
	dim = 0;
	cap = n;
}
int priority::getFiuStang(int i) {
	return 2 * i + 1;
}
int priority::getFiuDrept(int i) {
	return 2 * i + 2;
}
int priority::getTata(int i) {
	return (i - 1) / 2;
}

void priority::extract_max()
{
	H[0] = H[dim - 1];
	dim--;
	sift_down(0);
}
void priority::sift_Up(int i) {
	int tata, tmp;
	tata = getTata(i);
	while (tata >= 0 && H[tata] < H[i]) {
		tmp = H[tata];
		H[tata] = H[i];
		H[i] = tmp;
		i = tata;
		tata = getTata(i);
	}
}
void priority::sift_down(int i)
{
	int fiu = i, aux;
	int stang = getFiuStang(i);
	int drept = getFiuDrept(i);
	if (stang < dim && H[fiu]<H[stang])
		fiu = stang;
	if (drept < dim && H[fiu] < H[drept])
		fiu = drept;
	if (fiu != i)
	{
		aux = H[i];
		H[i] = H[fiu];
		H[fiu] = aux;
		sift_down(fiu);
	}
}
void priority::insert(int k) {
	if (dim == cap)
		cout << "Heap plin!!";
	else {
		dim++;
		H[dim - 1] = k;
		sift_Up(dim - 1);
	}
}
void priority::afisare() {
	for (int i = 0; i < dim; i++)
		cout << H[i] << ' ';

}
priority::~priority()
{
	delete[] H;
}
