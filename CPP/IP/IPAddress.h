#pragma once
#include <iostream>
#include <fstream>
#include <string.h>

using namespace std;

class IP_Address
{
private:
	int x1, x2, x3, x4;
public:
	IP_Address();
	IP_Address(int, int, int, int);
	~IP_Address();
	friend istream& operator >> (istream& flux, IP_Address& ip);
	friend ostream& operator << (ostream& flux, IP_Address ip);
	void set_ip(int, int, int, int);
	int get_x1();
	int get_x2();
	int get_x3();
	int get_x4();

};