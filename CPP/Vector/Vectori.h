#define _CRT_SECURE_NO_WARNINGS
#include<iostream>
class Vectori {
private:
	int data;
public:
	Vectori();
	Vectori(int a);
	friend std::istream &operator >> (std::istream &flux, Vectori &v);
	friend std::ostream &operator <<(std::ostream &flux, Vectori v);
	friend bool operator<(Vectori v1, Vectori v2);
	void setData(int a);
	int getData();
	~Vectori();
};