#pragma once
#include "BasicIncludesAndDefines.h"
#include "Surface.h"

class Disk : public Surface {
public:
	Disk(const glm::vec3 &position, const glm::vec3 &n, float rad, const Material &mat);
	~Disk() {}
	Disk(const glm::vec3 & pos, const glm::vec3 & n, float rad, const Material & material, const PhongMaterial & mat);
	virtual HitRecord findClosestIntersection(const glm::vec3 &origin, const glm::vec3 &dir);
protected:
	glm::vec3 center, normal;
	float radius;
};