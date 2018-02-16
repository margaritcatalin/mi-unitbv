#include"Heap.h"
Heapmin::Heapmin(int n)
{
	H = new int[n];
	dimensiuneHeap = 0;
	capHeap = n;
}
int Heapmin::getFiuStang(int i) {
	return 2 * i + 1;
}
int Heapmin::getFiuDrept(int i) {
	return 2 * i + 2;
}
int Heapmin::getTata(int i) {
	return (i - 1) / 2;
}
int Heapmin::getMin() 
{
	if (dimensiuneHeap == 0)
		cout << "Heap gol!";
	else
		return H[0];
}
void Heapmin::sift_Up(int i) {
	int tata, tmp;
		tata = getTata(i);
		while (tata>=0 && H[tata] > H[i]) {
			tmp = H[tata];
			H[tata] = H[i];
			H[i] = tmp;
			i = tata;
			tata = getTata(i);
		}
}

void Heapmin::insert(int x) {
	if (dimensiuneHeap == capHeap)
		cout << "Heap plin!!";
	else {
		dimensiuneHeap++;
		H[dimensiuneHeap-1] = x;
		sift_Up(dimensiuneHeap-1);
	}
}
void Heapmin::afisare() {
	for (int i = 0; i < dimensiuneHeap; i++)
		cout << H[i]<<' ';

}
Heapmin::~Heapmin() 
{
	delete[] H;
}
