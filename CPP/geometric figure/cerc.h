#include"Figura.h"
# define pi 3.14;
class Cerc : public Figura
{
protected:
	float x, y, R;
public:
	Cerc(float a, float b, float c);
	~Cerc();
	float arie();
	void afisare();
	float perim();
	bool operator<(Cerc &c);
	float getX()const;
	float getY()const;
};
