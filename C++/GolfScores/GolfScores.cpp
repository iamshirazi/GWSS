/*
 * C++ version of Golf.java
 */

#include <iostream>
#include <cstdlib>

using namespace std;

/*
 * 
 */
int main() {

    // VARIABLES
    int total = 0;
    int golfScores[18];

    // GET SCORES
    for (int g = 0; g < (sizeof (golfScores) / sizeof (*golfScores)); g++) {
        golfScores[g] = (int) (rand() % 5 + 1);
    }

    // PRINT SCORES
    for (int m = 0; m < (sizeof (golfScores) / sizeof (*golfScores)); m++) {
        std::cout << "Score at hole " << (m + 1) << ": " << golfScores[m] << "\n";
    }
    
    // GET TOTAL SCORE
    for (int i = 0; i < (sizeof (golfScores) / sizeof (*golfScores)); i++) {
        total = total + golfScores[i];
    }
    
    std::cout << "Total Score is: " << total;
    
    
}