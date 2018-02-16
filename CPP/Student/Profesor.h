
#include"Persoana.h"
class Profesor :public Persoana {
protected:
	int idProfesor;
	char materii[100];
public:
	Profesor();
	Profesor(int nrP, char* spat);
	~Scaun();
	void afisare();
	int getnrPicioare();
	char* getSpatar();
};