#include"Student.h"
#include"Profesor.h"
#include <fstream>
int main()
{
	int n;
	double **note;
	Student d;
	ifstream f("note.txt");
	f >> n;//nr student
	f >> m;//cate note sunt
	note = new double*[n];
	for (int i = 0; i < n; i++)
		note[i] = new double[m];
	for (int i = 0; i < n; i++)
		for(int j=0;j<m;j++)
		f>>	note[i][j];
	for (int i = 0; i < n; i++)
		d = new Student(i, note[i], m);
	for (int i = 0; i < n; i++)
		delete[]note[i];
	delete[]note;
	f.close();
	return 0;
}
