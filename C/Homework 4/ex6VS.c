#include<stdio.h>
void main()
{
    double x;
	unsigned n,i;
    printf_s("Introduceti cate numere doresti  :");
    scanf_s("%u",&n);
    for(i=1;i<=n;i++)
    {
        printf_s("Introduceti numarul :");
        scanf_s("%lf",&x);
        printf_s("\nPartea intreaga este:%d", (int)x);
        printf_s("\nPartea fractionara este:%lf", x-(int)x);//1,78 tranformarea partii fractionare in parte intreaga
    }
	getch();
}
