
#include"Persoana.h"
class Student:public Persoana{
protected:
	int idStudent;
	double *note;
public:
	Student();
	Student(int id, double *v);
	~Student();
	int getIdStudent();
	int getNote();
};
