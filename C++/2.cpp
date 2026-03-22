#include <stdio.h>
int main() {
    int number1,number2;

    printf("Enter two integers,and I will tell you the relationships they satisfy:");
    scanf("%d %d", &number1 , &number2);
    

    // true if number is less than 0
    if (number1 == number2) {
        printf("%d equal to %d.\n", number1, number2);
    }
    
    if (number1 <= number2){
      printf("%d less than or equal to %d.\n", number1, number2);
  }
  
  if (number1 >= number2){
      printf("%d greater than or equal to %d.\n", number1, number2);
  }




    return 0;
}
