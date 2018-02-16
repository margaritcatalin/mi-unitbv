#include"Nod.h"
Nod::Nod(const Nod & ceva)
{
		this->info = ceva.info;
		this->color = NULL;
}
Nod::Nod()
{
	this->info = NULL;
	color = NULL;
}

Nod::~Nod()
{
	info = NULL;
	color = NULL;
}
