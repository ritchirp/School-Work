#include "ellipsoid.h"

ellipsoid::ellipsoid(const glm::vec3 & centerPt, float xRad, float yRad, float zRad)
{
	center = centerPt;
	xRadius = xRad;
	yRadius = yRad;
	zRadius = zRad;
}

int ellipsoid::pointLocation(const glm::vec3 & pt)
{
	float val = pow((pt.x - center.x), 2) / pow(xRadius, 2) + pow((pt.y - center.y), 2) / pow(yRadius, 2) + pow((pt.z - center.z), 2) / pow(zRadius, 2) - 1;
	if (val < 0)
		return -1;
	else if (val > 0)
		return 1;
	else
		return 0;
}
