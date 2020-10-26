//exposed to sunlight
#include <bits/stdc++.h>
#include <iostream>
using namespace std;

// Returns Length of buildings exposed to sunlight
float lengthBuildings(float arr[][2], float source[2])
{
//Adding lengths of smaller buildings
float xMin = arr[0][0];
for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 1; j++)
        {
if(arr[i][j] < xMin){
xMin = arr[i][j];
}
        }
    }
    float length;
for (int j = 0; j < 8; j++)
        {
for (int k = 0; k < 1; k++) {
if(arr[j][k] == xMin){
length = sqrt(pow(arr[j+1][k] - arr[j][k], 2) +  
                pow(arr[j+1][k+1] - arr[j][k+1], 2) * 1.0) +
sqrt(pow(arr[j+3][k] - arr[j][k], 2) +  
                pow(arr[j+3][k+1] - arr[j][k+1], 2) * 1.0);
k = 2;
j = 9;
break;
}
            }
       }
//To check where sunlight is intersecting the tallest building to add that part
// Line AB represented as a1x + b1y = c1
double a1 = arr[1][1] - arr[0][1];
double b1 = arr[0][0] - arr[1][0];
double c1 = a1*(arr[0][0]) + b1*(arr[0][1]);

// Line CD represented as a2x + b2y = c2
double a2 = arr[7][1] - source[1];
double b2 = source[0] - arr[7][0];
double c2 = a2*(source[0])+ b2*(source[1]);

double determinant = a1*b2 - a2*b1;
    double intersectionPoint[2];
//if determinant is 0 lines are parallel i.e sunlight not intersecting with the building
if (determinant != 0)
{
double x = (b2*c1 - b1*c2)/determinant;
double y = (a1*c2 - a2*c1)/determinant;
intersectionPoint[0] = x;
intersectionPoint[1] = y;
}
length = length + sqrt(pow(intersectionPoint[0] - arr[0][0], 2) +  
    pow(intersectionPoint[1] - arr[0][1], 2) * 1.0) +
sqrt(pow(arr[3][0] - arr[0][0], 2) +  
    pow(arr[3][1] - arr[0][1], 2) * 1.0);

return length;
}

int main()
{
float arr[8][2] = {{4,0}, {4,-5}, {7,-5}, {7,0}, {0.4,-2}, {0.4,-5}, {2.5,-5}, {2.5,-2}};
float source[] = {-3.5,1};
    float n = sizeof(arr)/sizeof(arr[0])/4;

    float result = lengthBuildings(arr, source);
cout << "Length of buildings exposed to sunlight : " << result;
return 0;
} 
