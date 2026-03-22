#include <iostream>
using namespace std;
int main()
{
int num0, num1, num2, num3, num4;
int sum;
cout<<”Enter five integers: “;
cin>> num0>> num1>> num2>> num3>> num4;
cout<<endl;
sum = num0 + num1 + num2 + num3 + num4;
cout<<”The sum of the numbers = “<<sum<<endl;
cout<<”The numbers in the reverse order are: “; 
cout<< num4 <<” “ << num3 <<” “ << num2 << ” “ << num1 << 
” “ << num0 << ” “ <<endl;
return 0;
}

