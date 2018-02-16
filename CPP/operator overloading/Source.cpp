#include <iostream>
using namespace std;

class Student
{
public:
	char* nume;
private:
	int matricol;
protected:
	float medie;
public:
	Student()
	{
		nume = new char[7];
		strcpy(nume, "Anonim");
		matricol = 0;
		medie = 0;
		cout<<"S-a apelat constructorul implicit"<<endl;
	}
	Student(char*n, int nr, float m)
	{
		this->nume = new char[strlen(n) + 1];
		strcpy(nume, n);
		matricol = nr;
		medie = m;
		cout<<"S-a apelat constructorul cu parametri"<<endl;
	}
	//Student(char *n = "Anonim", int nr = 0, float m=0) : matricol(nr), medie(m)
	//{
	//	strcpy(nume, n);
	//	cout<<"S-a apelat constructorul hibrid"<<endl;
	//}
	Student(const Student& s)
	{
		this->nume = new char[strlen(s.nume) + 1];
		strcpy(this->nume, s.nume);
		this->matricol = s.matricol;
		this->medie = s.medie;
		cout<<"S-a apelat constructorul de copiere"<<endl;
	}
	Student& operator=(const Student& s)
	{
		if(this->nume != NULL)
		{
			delete[] this->nume;
		}
		this->nume = new char[strlen(s.nume) + 1];
		strcpy(this->nume, s.nume);
		this->matricol = s.matricol;
		this->medie = s.medie;
		cout<<"S-a apelat operator="<<endl;
		return *this;
	}

	~Student()
	{
		delete[] this->nume;
		cout<<endl<<"S-a apelat destructorul";
	}
	void init(char* n = "Anonim", int nr=0, float m=0)
	{
		strcpy(nume, n);
		matricol = nr;
		medie = m;
	}
	char* returneaza_nume()
	{
		return this->nume;
	}
	void modifica_nume(char* n)
	{
		if (this->nume)
		{
			delete[] this->nume;
		}
		this->nume = new char[strlen(n) + 1];
		strcpy(this->nume, n);
	}
	float get_medie()
	{
		if (this->medie > 9)
		{
			return this->medie;
		}
		else
		{
			return 0;
		}
	}
	void set_medie(float m)
	{
		this->medie = m;
	}
	double operator+(Student& s)
	{
		return this->medie + s.medie;
	}

	char operator[](int i)
	{
		if(this->nume!=NULL)
		if(i>=0 && i<strlen(this->nume))
		{
			return nume[i];
		}
	}

	void afiseaza_adresa();

	friend const Student& operator++(Student&);
	friend const Student operator++(Student&, int);
	friend double operator+(Student&, double);
	friend double operator+(double, Student&);
	friend istream& operator>>(istream&, Student&);
	friend ostream& operator<<(ostream&, Student);
};

void Student::afiseaza_adresa()
{
	cout<<"Adresa obiectului curent este: "<<this<<endl;
}

const Student& operator++(Student& s)
{
	s.medie++;
	return s;
}

const Student operator++(Student& s, int i)
{
	Student aux = s;
	s.medie++;
	return aux;
}

double operator+(Student& s, double x)
{
	return s.medie + x;
}

double operator+(double x, Student& s)
{
	return s.medie + x;
}

istream& operator>>(istream& intrare, Student& s)
{
	cout<<"Nume: ";
	char nume[40];
	intrare>>nume;
	s.modifica_nume(nume);
	cout<<"Medie: ";
	intrare>>s.medie;
	cout<<"Matricol: ";
	intrare>>s.matricol;
	return intrare;
}

ostream& operator<<(ostream& iesire, Student s)
{
	iesire<<"Studentul "<<s.nume<<" are matricolul "<<s.matricol<<" si media "<<s.medie<<"."<<endl;
	return iesire;
}

void main()
{
	Student s1;
	Student s2("Nume", 123, 10);
	//s.init("Nume", 123, 5);
	cout<<s1.nume<<endl;
	//s.afiseaza_adresa();
	cout<<s2.get_medie();
	//Student s3(s2);
	Student s4 = s2;
	Student s5;
	s5=s2;
	s5=++s2;
	//s3 = s2;
	cout<<s5+2<<endl;
	cout<<2+s5<<endl;
	cout<<s2+s5<<endl;
	Student s6;
	cin>>s6;
	cout<<s6<<endl;
	cout<<s6[2];
}