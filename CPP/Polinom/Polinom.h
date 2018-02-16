# include <iostream>
class Polinom
{
private:
	int grad;
	double *data;
public:
	Polinom();
	Polinom(int p);
	Polinom(const Polinom& ceva);
	~Polinom();
	friend std::istream& operator >> (std::istream&, Polinom& p);
	friend std::ostream& operator <<(std::ostream&, const Polinom p);
	int getGrad()const;
	double getDataE(int b)const;
	bool operator<(Polinom nr)const;
	Polinom operator=(const Polinom nr);
	Polinom operator+(Polinom x);
};


