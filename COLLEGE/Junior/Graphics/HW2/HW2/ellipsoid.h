#pragma once
#include <glm/glm.hpp>

class ellipsoid {	
private:
	glm::vec3 center;
	float xRadius, yRadius, zRadius;
public:
	ellipsoid(const glm::vec3 &centerPt, float xRad, float yRad, float zRad);
	int pointLocation(const glm::vec3 &pt);	// -1 (inside), 0 (on), +1 (outside)
};