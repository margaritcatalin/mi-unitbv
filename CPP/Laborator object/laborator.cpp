#define _CRT_SECURE_NO_WARNINGS
#include"Laborator.h"
#include<string>

Laborator::Laborator()
{

}

Laborator::~Laborator()
{

}
Laborator::Laborator(char* ob)
{
	strcpy(this->obiect, ob);
}

char * Laborator::getObiect()
{
	return this->obiect;
}