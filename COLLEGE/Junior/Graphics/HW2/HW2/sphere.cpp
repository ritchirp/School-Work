#include "sphere.h"



sphere::sphere(const glm::vec3 & centerPt, float r)
{
	center = centerPt;
	radius = r;
}

int sphere::pointLocation(const glm::vec3 & pt)
{
	float val = pow((center.x - pt.x), 2) + pow((center.y - pt.y), 2) + pow((center.z - pt.z), 2) - pow(radius, 2);
	if (val < 0)
		return -1;
	else if (val > 0)
		return 1;
	else
		return 0;

}

glm::vec3 sphere::unitNormal(const glm::vec3 & pt)
{
	if (pointLocation(pt) != 0)
		return glm::vec3(0, 0, 0);
	else {
		glm::vec3 out = glm::vec3(pt.x - center.x, pt.y - center.y, pt.z - center.z);
		out = glm::normalize(out);
		return out;
	}
}
