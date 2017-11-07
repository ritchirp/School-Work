#pragma once
#include <glm/glm.hpp>
class sphere {	
private:
	glm::vec3 center;
	float radius;
public:
	sphere(const glm::vec3 &centerPt, float r);
	int pointLocation(const glm::vec3 &pt);	// return -1 (inside), 0 (on), +1 (outside)
	glm::vec3 unitNormal(const glm::vec3 &pt);	// return <0,0,0> if not on sphere
};