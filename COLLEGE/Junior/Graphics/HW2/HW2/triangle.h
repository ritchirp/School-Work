#pragma once
#include <glm/glm.hpp>

class triangle {
private:
	glm::vec2 A, B, C;
public:
	triangle(const glm::vec2 &A, const glm::vec2 &B, const glm::vec2 &C);
	float area();
	int pointLocation(const glm::vec2 &pt);	  
};