#include "parametricLine.h"

parametricLine::parametricLine(const glm::vec3 & p0, const glm::vec3 & p1)
{
	this->p0 = p0;
	this->p1 = p1;
}

glm::vec3 parametricLine::getPoint(float t)
{
	return p0 + (t*(p1  - p0));
}
