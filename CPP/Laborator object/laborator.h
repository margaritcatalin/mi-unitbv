#pragma once
#include<iostream>
class Laborator {
protected:
	char obiect[100];
public:
	Laborator();
	~Laborator();
	Laborator(char* ob);
	char *getObiect();
	virtual void afisare() = 0;
};
