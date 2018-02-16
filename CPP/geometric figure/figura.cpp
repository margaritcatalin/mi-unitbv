#define _CRT_SECURE_NO_WARNINGS
#include"Figura.h"

char* Figura::getDenumire()
{
	return this->den;
}

Figura::Figura()
{
}

Figura::Figura(char * den)
{
	strcpy(this->den, den);
}

Figura::~Figura()
{
}
