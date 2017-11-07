#include "plane.h"

plane::plane(const glm::vec3 & pt, const glm::vec3 & normalVector)
{
	point = pt;
	normal = normalVector;
}

plane::plane(const glm::vec3 & pt1, const glm::vec3 & pt2, const glm::vec3 & pt3)
{
	point = pt1;
	normal = glm::cross((pt2 - pt1), (pt3 - pt1));
}


bool plane::onPlane(const glm::vec3 & pt)
{
	return glm::dot(normal, pt - point) == 0;
}
