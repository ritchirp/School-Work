#include <cmath>
#include <glm/glm.hpp>
#include "BasicIncludesAndDefines.h"
#include "parametricLine.h"
#include "plane.h"
#include "ellipsoid.h"
#include "sphere.h"
#include "triangle.h"

int main(int argc, char** argv) {

	std::cout << glm::normalize(glm::vec3(0, 2, 0)).y;

	// Sphere testing

	std::cout << "Sphere testing\n";

	// An easy sphere to test with
	sphere sphere1(glm::vec3(0, 0, 0), 1);

	std::cout << sphere1.pointLocation(glm::vec3(1, 0, 0)) << "\n"; // expected: 0
	std::cout << sphere1.pointLocation(glm::vec3(0.5, 0.5, 0.5)) << "\n"; // expected: -1
	std::cout << sphere1.pointLocation(glm::vec3(0, 1.1, 0)) << "\n"; // expected: 1

	glm::vec3 temp = sphere1.unitNormal(glm::vec3(0, 1.1, 0));
	std::cout << "(" << temp.x << ", " << temp.y << ", " << temp.z << ")" << "\n"; // expected: (0,0,0)
	temp = sphere1.unitNormal(glm::vec3(0, 0.9, 0));
	std::cout << "(" << temp.x << ", " << temp.y << ", " << temp.z << ")" << "\n"; // expected: (0,0,0)
	temp = sphere1.unitNormal(glm::vec3(0, 1, 0));
	std::cout << "(" << temp.x << ", " << temp.y << ", " << temp.z << ")" << "\n"; // expected: (0,1,0)

	 
	sphere1 = sphere(glm::vec3(-2, 2, 3), 2);

	std::cout << sphere1.pointLocation(glm::vec3(-2, 2, 5)) << "\n"; // expected: 0
	std::cout << sphere1.pointLocation(glm::vec3(-1.5, 2.5, 4.5)) << "\n"; // expected: -1
	std::cout << sphere1.pointLocation(glm::vec3(-4, 2, 4)) << "\n"; // expected: 1

	temp = sphere1.unitNormal(glm::vec3(-4, 3, 5));
	std::cout << "(" << temp.x << ", " << temp.y << ", " << temp.z << ")" << "\n"; // expected: (0,0,0)
	temp = sphere1.unitNormal(glm::vec3(-1.5, 2.5, 4.5));
	std::cout << "(" << temp.x << ", " << temp.y << ", " << temp.z << ")" << "\n"; // expected: (0,0,0)
	temp = sphere1.unitNormal(glm::vec3(-2, 2, 5));
	std::cout << "(" << temp.x << ", " << temp.y << ", " << temp.z << ")" << "\n"; // expected: (0,0,1)


	// Ellipsoid testing
	
	std::cout << "Ellipsoid testing\n";
	ellipsoid ellipsoid1 = ellipsoid(glm::vec3(0, 0, 0), 1, 2, 3);

	// the following should return -1
	std::cout << ellipsoid1.pointLocation(glm::vec3(0, 0, 0)) << "\n";
	std::cout << ellipsoid1.pointLocation(glm::vec3(0.5, 0.5, 0.5)) << "\n";
	// the following should return 0
	std::cout << ellipsoid1.pointLocation(glm::vec3(1, 0, 0)) << "\n";
	std::cout << ellipsoid1.pointLocation(glm::vec3(0, 2, 0)) << "\n";
	std::cout << ellipsoid1.pointLocation(glm::vec3(0, 0, 3)) << "\n";
	// the following should return 1
	std::cout << ellipsoid1.pointLocation(glm::vec3(0, 3, 0)) << "\n";
	std::cout << ellipsoid1.pointLocation(glm::vec3(1, 2, 3)) << "\n";


	// Plane testing

	std::cout << "Plane testing\n";

	plane plane1(glm::vec3(0, 0, 0), glm::vec3(1, 1, 1));
	plane plane2(glm::vec3(0, 0, 1), glm::vec3(1, 0, 1), glm::vec3(1, 1, 1));

	// the following should return true
	std::cout << plane1.onPlane(glm::vec3(-1, -1, 2)) << "\n";
	std::cout << plane2.onPlane(glm::vec3(1, 0, 1)) << "\n";
	//the following should return false
	std::cout << plane1.onPlane(glm::vec3(1, 1, 1)) << "\n";
	std::cout << plane2.onPlane(glm::vec3(0, 0, 0)) << "\n";

	// Parametric Line testing

	std::cout << "Parametric Line testing\n";

	parametricLine pl(glm::vec3(0,0,0), glm::vec3(1, 2, 3));

	temp = pl.getPoint(0);
	std::cout << "(" << temp.x << ", " << temp.y << ", " << temp.z  << ")" << "\n"; // expected: (0,0,0)
	temp = pl.getPoint(2);
	std::cout << "(" << temp.x << ", " << temp.y << ", " << temp.z << ")" << "\n";// expected: (2,4,6)
	temp = pl.getPoint(-1);
	std::cout << "(" << temp.x << ", " << temp.y << ", " << temp.z << ")" << "\n"; // expected: (-1,-2,-3) 


	// Triangle testing

	std::cout << "Triangle testing\n";


	triangle tri1(glm::vec2(0, 0), glm::vec2(1, 0), glm::vec2(0, 1));

	std::cout << tri1.area() << "\n" ; // expected: 0.5
	std::cout << tri1.pointLocation(glm::vec2(0,0)) << "\n"; // expected: 0
	std::cout << tri1.pointLocation(glm::vec2(2,2)) << "\n"; // expected: 1
	std::cout << tri1.pointLocation(glm::vec2(0.1, 0.1)) << "\n"; // expected: -1


	return 0;
}

