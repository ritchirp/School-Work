#pragma once
#include <glm/glm.hpp>

class parametricLine {
private:
	glm::vec3 p0, p1;
public:
	parametricLine(const glm::vec3 &p0, const glm::vec3 &p1);
	glm::vec3 getPoint(float t);
};