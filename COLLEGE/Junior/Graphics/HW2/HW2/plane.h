#pragma once
#include <glm/glm.hpp>
class plane {	
private:
	glm::vec3 point;
	glm::vec3 normal;
public:
	plane(const glm::vec3 &pt1, const glm::vec3 &pt2, const glm::vec3 &pt3);
	plane(const glm::vec3 &pt, const glm::vec3 &normalVector);
	bool onPlane(const glm::vec3 &pt);	// true iff pt resides on the plane
};