#include<iostream>

class NrRat
{
	int a; //numaratorul fractiei
	int b; //numitorul fractiei
	int cmmdc(int, int); /*cmmdc-ul a doua nr. intregi folosit la determinarea fractiilor ireductibile*/
	void ireductibil(); //determinarea unei fractii ireductibile
public:
	NrRat(int = 0, int = 1); //constructor de initializare cu parametri impliciti
	int& retnumarator(); //functie ce returneaza numaratorul fractiei
	int& retnumitor(); //functie ce returneaza numitorul fractiei
	friend istream& operator >> (istream&, NrRat&); /*citirea unui numar rational*/
	friend ostream& operator<<(ostream&, NrRat); /*afisarea unui numar rational*/
	NrRat operator+(NrRat&); //adunarea a doua nr. rationale
	NrRat operator-(); //opusul unui numar rational
	NrRat operator-(NrRat&); //diferenta a doua nr. rationale
	NrRat operator*(NrRat&); //inmultirea a doua nr. rationale
	NrRat operator*(int); //inmultirea unui nr. complex cu un scalar
	friend NrRat operator*(int, NrRat&); /*inmultirea unui scalar cu un nr. complex*/
	NrRat operator!(); //inversul unui numar rational
	NrRat operator/(NrRat&); //impartirea a doua nr. rationale
};