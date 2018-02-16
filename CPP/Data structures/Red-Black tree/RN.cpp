#include "RN.h"
Nod* ARN::min(Nod* x)
{
	while (x->st != Nil)
		x = x->st;
	return x;
}
Nod* ARN::max(Nod* x)
{
	while (x->dr != Nil)
		x = x->dr;
	return x;
}
Nod* ARN::cautare(int k)
{
	Nod *x = rad;
	while (x != Nil && x->info != k)
		if (x->info>k)
			x = x->st;
		else
			x = x->dr;
	return x;
}
Nod* ARN::succesor(Nod* x)
{
	if (x->dr != Nil)
		return min(x->dr);
	else
	{
		Nod*y = new Nod;
		y = x->p;
		while (y != Nil && x == y->dr)
		{
			x = y;
			y = y->p;
		}

		return y;
	}
}
Nod * ARN::predecesor(Nod * x)
{
	Nod *y;
	if (x->st != Nil)
	{
		return max(x->st);
	}
	else
	{
		y = x->p;
		while (y != Nil && x == y->st)
		{
			x = y;
			y = y->p;
		}
		return y;
	}
}
int ARN::RotatieStanga(Nod *x)
{
	Nod *y;
	y = x->dr;
	x->dr = y->st;
	y->st->p = x;
	y->p = x->p;

	if (x->p == Nil)
		rad = y;
	else if (x == x->p->st)
		x->p->st = y;
	else
		x->p->dr = y;
	y->st = x;
	x->p = y;
	return 0;
}

int ARN::RotatieDreapta(Nod *x)
{
	Nod *y;

	y = x->st;
	x->st = y->dr;
	y->dr->p = x;
	y->p = x->p;

	if (x->p == Nil)
		rad = y;
	else if (x == x->p->dr)
		x->p->dr = y;
	else
		x->p->st = y;
	y->dr = x;
	x->p = y;
	return 0;
}

int ARN::insert(Nod *z)
{
	Nod *x, *y;

	y = Nil;
	x = rad;

	while (x != Nil)
	{
		y = x;
		if (z->info < x->info)
			x = x->st;
		else if(z->info > x->info)
			x = x->dr;
		else
			return -1;
	}
	z->p = y;
	z->color = 'R';
	z->st = z->dr = Nil;
	if (y == Nil)
		rad = z;
	else
	{
		if (y->info > z->info)
			y->st = z;
		else
			y->dr = z;
	}
	fixup(z);
	return 0;
}
int ARN::fixup(Nod *z)
{
	Nod *y;

	while (z->p->color == 'R')
	{
		if (z->p == z->p->p->st)
		{
			y = z->p->p->dr;

			if (y->color == 'R')
			{
				z->p->color = 'B';
				y->color = 'B';
				z->p->p->color = 'R';
				z = z->p->p;
			}
			else
			{
				if (z == z->p->dr)
				{
					z = z->p;
					RotatieStanga(z);
				}

				z->p->color = 'B';
				z->p->p->color = 'R';
				RotatieDreapta(z->p->p);
			}
		}
		else
		{
			y = z->p->p->st;

			if (y->color == 'R')
			{
				z->p->color = 'B';
				y->color = 'B';
				z->p->p->color = 'R';
				z = z->p->p;
			}
			else
			{
				if (z == z->p->st)
				{
					z = z->p;
					RotatieDreapta(z);
				}
				z->p->color = 'B';
				z->p->p->color = 'R';
				RotatieStanga(z->p->p);
			}
		}
	}

	rad->color = 'B';
	return 0;
}

int ARN::sterge(Nod *z)
{
	Nod *x, *y;
	y = z;
	char ccolor = y->color;
	if (z->st == Nil)
	{
		x = z->dr;
		transplant(z, z->dr);
	}
	else if (z->dr == Nil)
	{
		x = z->st;
		transplant(z, z->st);
	}
	else
	{
		y = min(z->dr);
		ccolor = y->color;
		x = y->dr;
		if (y->p == z)
		{
			x->p = y;
		}
		else {
			transplant(y, y->dr);
			y->dr = z->dr;
			y->dr->p = y;
		}
		transplant(z, y);
		y->st = z->st;
		y->st->p = y;
		y->color = z->color;
	}
	if (ccolor == 'B')
	{
		delete_fixup(x);
	}

	return 0;
}

int ARN::transplant(Nod *u, Nod *v)
{
	if (u->p == Nil)
		rad = v;
	else
	{
		if (u == u->p->st)
			u->p->st = v;
		else
			u->p->dr = v;

	}
/*	if (v != Nil)
		v->p = u->p;*/
	return 0;
}

int ARN::delete_fixup(Nod *x)
{
	Nod *w;

	while (x != rad && x->color == 'B')
	{
		if (x == x->p->st)
		{
			w = x->p->dr;

			if (w->color == 'R')
			{
				w->color = 'B';
				x->p->color = 'R';
				RotatieStanga(x->p);
				w = x->p->dr;
			}

			if (w->st->color == 'B' && w->dr->color == 'B')
			{
				w->color = 'R';
				x = x->p;
			}
			else {
				if (w->dr->color == 'B')
				{
					w->st->color = 'B';
					w->color = 'R';
					RotatieDreapta(w);
					w = x->p->dr;
				}

				w->color = x->p->color;
				x->p->color = 'B';
				w->dr->color = 'B';
				RotatieStanga(x->p);
				x = rad;
			}
		}
		else
		{
			w = x->p->st;

			if (w->color == 'R')
			{
				w->color = 'B';
				x->p->color = 'R';
				RotatieDreapta(x->p);
				w = x->p->st;
			}

			if (w->dr->color == 'B' && w->st->color == 'B')
			{
				w->color = 'R';
				x = x->p;
			}
			else {
				if (w->st->color == 'B')
				{
					w->dr->color = 'B';
					w->color = 'R';
					RotatieStanga(w);
					w = x->p->st;
				}

				w->color = x->p->color;
				x->p->color = 'B';
				w->st->color = 'B';
				RotatieDreapta(x->p);
				x = rad;
			}
		}
	}

	x->color = 'B';

	return 0;
}

void ARN::SRD(Nod *n)
{
	if (n != Nil)
	{
		SRD(n->st);
		cout << n->info << '(' << n->color << ") ";
		SRD(n->dr);
	}
}
void ARN::RSD(Nod *n)
{
	if (n != Nil)
	{
		cout << n->info << '(' << n->color << ") ";
		RSD(n->st);
		RSD(n->dr);
	}
}
void ARN::SDR(Nod *n)
{
	if (n != Nil)
	{
		SDR(n->st);
		SDR(n->dr);
		cout << n->info << '(' << n->color << ") ";
	}
}
void ARN::postOrderDelete(Nod *n)
{
	if (n != Nil)
	{
		postOrderDelete(n->st);
		postOrderDelete(n->dr);
		delete(n);
	}
}

Nod* ARN::getRad()
{
	return rad;
}

ARN::ARN()
{
	this->Nil = new Nod();
	this->rad = Nil;
}

ARN::~ARN()
{
	postOrderDelete(this->rad);
	delete (this->Nil);
}