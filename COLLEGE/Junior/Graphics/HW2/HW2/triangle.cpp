#include "triangle.h"

triangle::triangle(const glm::vec2 & A, const glm::vec2 & B, const glm::vec2 & C)
{
	this->A = A;
	this->B = B;
	this->C = C;
}

float triangle::area()
{
	return (0.5) * glm::abs((B.x - A.x)*(C.y - A.y) - (C.x - A.x)*(B.y - A.y));
}

int triangle::pointLocation(const glm::vec2 & pt)
{
	float a = triangle(A, C, pt).area() / this->area();
	float b = triangle(A, B, pt).area() / this->area();
	float c = triangle(B, C, pt).area() / this->area();

	if (a == 0 || b == 0 || c == 0)
		return 0;
	else if (a >= 0 && a <= 1 && b >= 0 && b <= 1 && c >= 0 && c <= 1)
		return -1;
	else
		return 1;
}
