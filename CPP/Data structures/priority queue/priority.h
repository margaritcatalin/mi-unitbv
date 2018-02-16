#include<iostream>
using namespace std;
class priority {
private:
	int *H;
	int dim;
	int cap;
public:
	priority(int n);
	void extract_max();
	int getFiuStang(int i);
	int getFiuDrept(int i);
	int getTata(int i);
	void insert(int k);
	void sift_Up(int i);
	void sift_down(int i);
	void afisare();
	~priority();
};