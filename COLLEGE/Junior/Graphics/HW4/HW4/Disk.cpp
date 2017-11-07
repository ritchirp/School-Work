#include "Disk.h"
#include "Plane.h"
#include <glm/glm.hpp>

Disk::Disk(const glm::vec3 &pos, const glm::vec3 &n, float rad,
			const Material &material, const PhongMaterial & mat)
	: Surface(material), center(pos), normal(n), radius(rad) {
	phongMat = mat;
}

HitRecord Disk::findClosestIntersection(const glm::vec3 &rayOrigin,
										const glm::vec3 &rayDirection) {
	Plane plane(center, normal, material, phongMat);
	HitRecord hitRecord = plane.findClosestIntersection(rayOrigin, rayDirection);
	if (glm::distance(hitRecord.interceptPoint, center) > radius) {
		hitRecord.t = FLT_MAX;
	}
	return hitRecord;
}
