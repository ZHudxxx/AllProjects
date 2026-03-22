#include <iostream>

using std::cout;
using std::cin;
using std::endl;
using std::ios;
using std::fixed;

#include <iomanip>

using std::setw;
using std::setiosflags;
using std::setprecision;

#include <cmath>


//function prototype
double calculateCharge(double);
double Totalrate(double);

int count;
int total_rate;
int total_charge;

int main()

{
    int num;
    int charge;
    int count = 1;   
    int total_rate = 0 ;
    int total_charge = 0 ;

    for( int i = 0; i < 3; ++i )

    {
        
        cout << "enter water rates ";
        cin >> num ;
        
        cout<< setw(4)<< "Water " << setw(20)<< "Rates" << setw(18)<< "CHARGE\n";
        cout<< count << setw(20)<< num << setw(18)<< fixed << setprecision( 2 ) << calculateCharge (charge) << endl;
        
        charge = charge;        
        count = count + 1;
        total_rate = total_rate + num;
        total_charge = total_charge + charge;
                
    }
        cout<< setw(05)<< "TOTAL RATES" << setw(10)<< total_rate << setw(16)<< fixed << setprecision( 2 ) << endl;
        cout << fixed << setprecision( 2 ); 
        cout<< setw(10)<< "TOTAL CHARGES"<< setw(10)<< total_charge << setw(16)<< endl;
        cout<< setw(10)<< "TOTAL CHARGES"<< setw(10)<< charge << setw(16)<< endl;

        return 0;
}//end main



double calculateCharge( double x)
{

double charge;       

    if (x <21 )
          charge = 0.60;
    
    else if (x <35)
           charge = 1.65;

    else if (x > 35)
            charge = 2.96 + (x - 3) * (.5);

return charge;

}
