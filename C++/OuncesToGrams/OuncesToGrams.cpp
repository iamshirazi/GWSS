/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include <iostream>
#include <cmath>
#include <iomanip>


using namespace std;

/*
 * 
 */
int main() {
    
    
    
    // VARIABLES
    int start = 1;
    double end = 15;        
    
    // OUTPUT TABLE OF OUNCES AND GRAMS  
    std::cout << "Ounces" << setw(12) << "Grams" << "\n";
    
    for ( double ounces = start ; ounces <= end  ; ounces++ ) {
        double grams = 28.35 * ounces ; 
        std::abs(grams);
        std::setprecision(2);
        std::cout << setw(3) << ounces << setw(15) << grams << "\n";
    }
}

