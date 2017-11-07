#pragma once

#include <iostream>
#include "BasicIncludesAndDefines.h"
#include "HitRecord.h"
#include "Surface.h"

HitRecord findIntersection(const glm::vec3 &e, const glm::vec3 &d, const std::vector<std::shared_ptr<Surface>> & surfaces);

struct PositionalLight {
	bool isOn;
	glm::vec3 lightPosition;
	glm::vec3 attenParams;
	bool attenIsOn;

	virtual color illuminate(const HitRecord &hit, const glm::vec3 &eyeVector, bool inShadow) const {

		return (isOn && !inShadow) ? color(1, 1, 1, 1) : color(0, 0, 0, 1);
	}

	float attenFactor(float d) {
		return 1.0/(attenParams.x + attenParams.y * d + attenParams.z * d * d);
	}

	PositionalLight(const glm::vec3 &pos)
		: lightPosition(pos) {
		attenParams = glm::vec3(1, 0, 0);
	}
	friend std::ostream &operator << (std::ostream &os, const PositionalLight &pl);
};


struct SpotLight : public PositionalLight {
	float FOV; // In radians
	glm::vec3 dir; // direction of the light
	SpotLight(const glm::vec3 &position, float angle, glm::vec3 d) 
		: PositionalLight(position) {
		FOV = angle;
		dir = glm::normalize(d);
		attenIsOn = false;
	}


	virtual color illuminate(const HitRecord &hit, const glm::vec3 &eyeVector, bool inShadow) const {
		bool inRange = abs(glm::dot(dir, hit.interceptPoint - lightPosition)/(glm::length(hit.interceptPoint - lightPosition))) <= glm::cos(FOV);
		if (!inRange)
			return (!isOn && !inShadow) ? color(0, 0, 0, 1) : color(1, 1, 1, 1);
		else
			return color(0, 0, 0, 1);
	}


	friend std::ostream &operator << (std::ostream &os, const SpotLight &pl);
};


