/*
 * C++ version of AcidRain.java
 */

#include<iostream> 

using namespace std;

int main() {

    // CONSTANTS
    const double PH_ACID_MAX = 6.45;
    const double PH_ACID_MIN = 0;
    const double PH_BASE_MAX = 14;
    const double PH_BASE_MIN = 7.45;

    // VARIABLES
    double acidity;

    // INPUT
    std::cout << "Enter the pH level of the water.";
    std::cin >> acidity;

    // CODE TO DETERMINE IF FISH CAN SURVIVE IN A CERTAIN PH LEVEL
    if (acidity > PH_BASE_MAX || acidity < PH_ACID_MIN) {
        std::cout << "INVALID DATA";
    } else if (acidity >= PH_ACID_MAX && acidity <= PH_BASE_MIN) {
        std::cout << "NEUTRAL - FISH IN STREAMS, RIVERS AND LAKES WILL SURVIVE.";
    } else if (acidity < PH_ACID_MAX && acidity >= PH_ACID_MIN) {
        std::cout << "TOO ACIDIC - FISH IN STREAMS, RIVERS AND LAKES WILL NOT SURVIVE.";
    } else if (acidity > PH_BASE_MIN && acidity <= PH_BASE_MAX) {
        std::cout << "TOO ALKALINE - FISH IN STREAMS, RIVERS AND LAKES WILL NOT SURVIVE.";
    }
}