#include"Jucatori.h"
#include<algorithm>
int alegeJucator(Jucatori *J, int n)
{
	int x;
	for (int i = 0; i < n; i++)
	{
		std::cout << i << '.' << J[i].getNume() << std::endl;
	}
	std::cout << "Ce participant sunteti?" << std::endl << "Raspuns:";
	do {
		std::cin >> x;
	} while (x <0 || x >= n);
	std::cout<< std::endl << "Succes " << J[x].getNume() << '!' << std::endl;
	return x;
}
int checkwin(char *tabla)
{
	if (tabla[1] == tabla[2] && tabla[2] == tabla[3])

		return 1;
	else if (tabla[4] == tabla[5] && tabla[5] == tabla[6])

		return 1;
	else if (tabla[7] == tabla[8] && tabla[8] == tabla[9])

		return 1;
	else if (tabla[1] == tabla[4] && tabla[4] == tabla[7])

		return 1;
	else if (tabla[2] == tabla[5] && tabla[5] == tabla[8])

		return 1;
	else if (tabla[3] == tabla[6] && tabla[6] == tabla[9])

		return 1;
	else if (tabla[1] == tabla[5] && tabla[5] == tabla[9])

		return 1;
	else if (tabla[3] == tabla[5] && tabla[5] == tabla[7])

		return 1;
	else if (tabla[1] != '1' && tabla[2] != '2' && tabla[3] != '3'
		&& tabla[4] != '4' && tabla[5] != '5' && tabla[6] != '6'
		&& tabla[7] != '7' && tabla[8] != '8' && tabla[9] != '9')

		return 0;
	else
		return -1;
}
void afisaretabla(char *tabla,int Player1,int Player2,Jucatori *J)
{
	std::cout << std::endl << J[Player1].getNume() << "(X)  - " << J[Player2].getNume() << " (O)" << std::endl << std::endl;
	std::cout << "__________________" << std::endl;
	std::cout << "|     |     |     |" << std::endl;
	std::cout << "|  " << tabla[1] << "  |  " << tabla[2] << "  |  " << tabla[3] << "  |" << std::endl;

	std::cout << "|_____|_____|_____|" << std::endl;
	std::cout << "|     |     |     |" << std::endl;

	std::cout << "|  " << tabla[4] << "  |  " << tabla[5] << "  |  " << tabla[6] << "  |" << std::endl;

	std::cout << "|_____|_____|_____|" << std::endl;
	std::cout << "|     |     |     |" << std::endl;

	std::cout << "|  " << tabla[7] << "  |  " << tabla[8] << "  |  " << tabla[9] << "  |"<< std::endl;

	std::cout << "|     |     |     |" << std::endl;
	std::cout << "__________________" << std::endl;
}
void Joc(Jucatori *J,int n)
{
	char tabla[10] = { 'o','1','2','3','4','5','6','7','8','9' };
	int Player1 = alegeJucator(J,n);
	int Player2;
	do {
		Player2 = alegeJucator(J, n);
	} while (Player2 == Player1);
	char mark;
	int player = 1, mutare,i;
	do
	{
		afisaretabla(tabla,Player1,Player2,J);
		player = (player % 2) ? 1 : 2;
		if (player == 1)
		{
			std::cout << std::endl << J[Player1].getNume() << " introdu mutarea:";
		}
		else
		{
			std::cout << std::endl << J[Player2].getNume() << " introdu mutarea:";
		}
		std::cin >> mutare;

		mark = (player == 1) ? 'X' : 'O';

		if (mutare == 1 && tabla[1] == '1')

			tabla[1] = mark;
		else if (mutare == 2 && tabla[2] == '2')

			tabla[2] = mark;
		else if (mutare == 3 && tabla[3] == '3')

			tabla[3] = mark;
		else if (mutare == 4 && tabla[4] == '4')

			tabla[4] = mark;
		else if (mutare == 5 && tabla[5] == '5')

			tabla[5] = mark;
		else if (mutare == 6 && tabla[6] == '6')

			tabla[6] = mark;
		else if (mutare == 7 && tabla[7] == '7')

			tabla[7] = mark;
		else if (mutare == 8 && tabla[8] == '8')

			tabla[8] = mark;
		else if (mutare == 9 && tabla[9] == '9')

			tabla[9] = mark;
		else
		{
			std::cout << "Nu poti face aceasta mutare!";

			player--;
			std::cin.ignore();
			std::cin.get();
		}
		i = checkwin(tabla);

		player++;
	} while (i == -1);
	afisaretabla(tabla, Player1, Player2, J);
	if (i == 1)
	{
		--player;
		if (player == 1)
		{
			J[Player1].setCastigate(J[Player1].getCastigate() + 1);
			J[Player2].setPierdute(J[Player2].getPierdute() + 1);
			std::cout << J[Player1].getNume() << " a castigat!!";
		}
		else
		{
			J[Player2].setCastigate(J[Player2].getCastigate() + 1);
			J[Player1].setPierdute(J[Player1].getPierdute() + 1);
			std::cout << J[Player2].getNume() << " a castigat!!";
		}
	}
	else
	{
		J[Player1].setEgalitate(J[Player1].getEgalitate() + 1);
		J[Player2].setEgalitate(J[Player2].getEgalitate() + 1);
		std::cout << "Jocul s-a terminat la egalitate!";
	}

	std::cin.ignore();
	std::cin.get();
}
int main()
{
	Jucatori *J;
	int n;
	do {
		std::cout << "Cati jucatori joaca in turneu?" << std::endl << "Raspuns:";
		std::cin >> n;
	} while (n < 2);

	J = new Jucatori[n];
	for (int i = 0; i < n; i++)
	{
		std::cin >> J[i];
	}
	Joc(J, n);
	char x[3];
	do {
		std::cout << "Trecem la meciul urmator?" << std::endl << "Raspuns:";
		std::cin >> x;
		if (strcmp(x, "Da") == 0 || strcmp(x, "da") == 0)
		{
			Joc(J, n);
		}
		else
		{
			std::sort(J, J + n);
			std::cout << std::endl << "Topul jucatorilor:"<<std::endl;
			for (int i = 0; i < n; i++)
			{
				std::cout << J[i].getNume() << "||Victorii:" << J[i].getCastigate() << std::endl;
			}
		}
	} while (1);
	delete[] J;
	return 0;
}