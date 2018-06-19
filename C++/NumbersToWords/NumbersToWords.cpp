/*
 * C++ version of Golf.java
 */

#include <iostream>
#include <String>

using namespace std;

/*
 * 
 */

// OBJECTS
static string word;

// VARIABLES
static int number;
static int hundred;
static int ten;
static int one;
static int teen;
static int digitToUse;

int main() {
    
    int getNumber();
    void ones();
    void tens();
    void teens();
    void hundreds();
    
    number = getNumber();
    
    hundred = number / 100;
    teen = number % 100;
    ten = (number / 10) % 10;
    one = number % 10;
    digitToUse = one;

    if (number <= 0 || number >= 1000) {
        std::cout << "Invalid number." << "\n";
    } else if (number < 10) {
        ones();
    } else if (number <= 19) {
        teens();
    } else if (number <= 99) {
        tens();
        ones();
    } else if (number <= 999) {
        hundreds();
        if (ten == 0) {
            ones();
        } else if (ten == 1) {
            teens();
        } else {
            tens();
            ones();
        }
    }
    std::cout << "\n";

}

int getNumber() {

    std::cout << "Enter any number from 1 to 999." << "\n";
    std::cin >> number;
    return number;
}

void hundreds() {

    void ones();
    
    digitToUse = hundred;
    ones();
    std::cout << " Hundred";
    digitToUse = one;
}

void tens() {

    void ones();
    
    digitToUse = ten;
        switch (ten) {
            case 2:
                std::cout << " Twenty";
                break;
            case 3:
                std::cout << " Thirty";
                break;
            case 4:
                ones();
                std::cout << "ty";
                break;
            case 5:
                std::cout << " Fifty";
                break;
            case 6:
                ones();
                std::cout << "ty";
                break;
            case 7:
                ones();
                std::cout << "ty";
                break;
            case 8:
                ones();
                std::cout << "y";
                break;
            case 9:
                ones();
                std::cout << "ty";
                break;
            default:
                break;
        }
        digitToUse = one;
}

void teens() {

    switch (teen) {
            case 10:
                std::cout << "Ten";
                break;
            case 11:
                std::cout << "Eleven";
                break;
            case 12:
                std::cout << "Twelve";
                break;
            case 13:
                std::cout << "Thirteen";
                break;
            case 14:
                std::cout << "Fourteen";
                break;
            case 15:
                std::cout << "Fifteen";
                break;
            case 16:
                std::cout << "Sixteen";
                break;
            case 17:
                std::cout << "Seventeen";
                break;
            case 18:
                std::cout << "Eighteen";
                break;
            case 19:
                std::cout << "Nineteen";
                break;
            default:
                break;
        }
}

void ones() {

    switch (digitToUse) {
            case 1:
                std::cout << " One";
                break;
            case 2:
                std::cout << " Two";
                break;
            case 3:
                std::cout << " Three";
                break;
            case 4:
                std::cout << " Four";
                break;
            case 5:
                std::cout << " Five";
                break;
            case 6:
                std::cout << " Six";
                break;
            case 7:
                std::cout << " Seven";
                break;
            case 8:
                std::cout << " Eight";
                break;
            case 9:
                std::cout << " Nine";
                break;
            default:
                break;
        }
}