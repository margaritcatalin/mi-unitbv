#include "Student.h"
Student::Student()
{
}
Student::Student(int ids, double *not,int nrnote, char* num, char* adr, int data):Perosoana(num,adr,data)
{
	this->idStudent = ids;
	this->note = new double[nrnote];
	for (int i = 0; i < nrnote; i++)
		note[i] = not[i];
}

Student::~Student()
{
	delete[]this->note;
}

int Student::getIdStudent()
{
	return this->idStudent;
}

int Student::getNote()
{
	return this->note;
}
