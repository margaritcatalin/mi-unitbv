#include<iostream>
using namespace std;
class Heapmin {
private:
	int *H;
	int dimensiuneHeap;
	int capHeap;
public:
	Heapmin(int n);
	int getMin();
	int getFiuStang(int i);
	int getFiuDrept(int i);
	int getTata(int i); 
	void insert(int x);
	void sift_Up(int i);
	void afisare();
	~Heapmin();
};