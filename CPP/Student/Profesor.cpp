
#include "Profesor.h"
Profesor::Profesor()
{
}

Profesor::Profesor(int idp, char *mat, char* num, char* adr, int data) :Perosoana(num, adr, data)
{
	this->idProfesor = idp;
	strcpy(this->materii, mat);
}

Profesor::~Profesor()
{
}

int Profesor::getIdProf()
{
	return this->idProfesor;
}

char* Profesor::getMaterii()
{
	return this->materii;
}
