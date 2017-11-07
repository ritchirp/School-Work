#include "CylinderY.h"
#include "Quadric.h"
#include "Disk.h"

CylinderY::CylinderY(const glm::vec3 &position, float rad, float H, const color &material)
	: Surface(material), center(position), radius(rad), height(H) {
}

HitRecord CylinderY::findClosestIntersection(const glm::vec3 &rayOrigin,
										const glm::vec3 &rayDirection) {
	HitRecord theHit;
	QuadricParameters qParams = { 1/(pow(radius,2)), 0, 1 / (pow(radius,2)), 0, 0, 0, 0, 0, 0, -1 };
	QuadricSurface cyl(qParams, center, material);
	Disk cap1(glm::vec3(0, height / 2, 0) + center, glm::vec3(0, 1, 0), radius, material);
	Disk cap2(glm::vec3(0, -height / 2, 0) + center, glm::vec3(0, -1, 0), radius, material);
	HitRecord hits[2];
	int numInter = cyl.findIntersections(rayOrigin, rayDirection, hits);
	theHit.t = FLT_MAX;
	for (int i = 0; i < numInter; i++) {
		if (hits[i].interceptPoint.y <= center.y + height/2 && hits[i].interceptPoint.y >= center.y - height / 2)
			if(hits[i].t < theHit.t )
				theHit = hits[i];
	}
	HitRecord cap1Hit = cap1.findClosestIntersection(rayOrigin, rayDirection);
	HitRecord cap2Hit = cap2.findClosestIntersection(rayOrigin, rayDirection);
	if (cap1Hit.t < theHit.t)
		theHit = cap1Hit;
	if (cap2Hit.t < theHit.t)
		theHit = cap2Hit;

	return theHit;
}
