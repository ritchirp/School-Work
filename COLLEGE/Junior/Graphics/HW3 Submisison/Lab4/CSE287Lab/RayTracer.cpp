#include "RayTracer.h"

RayTracer::RayTracer(FrameBuffer & cBuffer, color defaultColor)
	:colorBuffer(cBuffer), defaultColor(defaultColor), recursionDepth(2), antiAliasingLevel(1), light(glm::vec3(0,0,0), glm::vec4(0,0,0,1)) {

}

RayTracer::~RayTracer(void) {
}

void RayTracer::setCameraFrame(const glm::vec3 & viewPosition, const glm::vec3 & viewingDirection, glm::vec3 up) {
	// Calculate and set the the w, u, and vdata members and 
	// set the eye data member to the viewing position.
	// TODO

	eye = viewPosition;
	// Squaring up a basis
	w = glm::normalize(-viewingDirection);
	u = glm::normalize(glm::cross(up, w));
	v = glm::normalize(glm::cross(w, u));
} // end setCameraFrame

void RayTracer::calculatePerspectiveViewingParameters(const float verticalFieldOfViewDegrees) {
	// Set the set the topLimit, bottomLimit, rightLimit, 
	// leftLimit, distToPlane, nx, and ny data members
	// TODO
	nx = (float)colorBuffer.getWindowWidth()/2;
	ny = (float)colorBuffer.getWindowHeight(); 
	topLimit = 1;
	bottomLimit = -topLimit;
	rightLimit = topLimit * nx / ny;
	leftLimit = -rightLimit;

	float rads = glm::radians(verticalFieldOfViewDegrees / 2);
	distToPlane = 1.0f / std::tan(rads);

} // end calculatePerspectiveViewingParameters

void RayTracer::calculateOrthographicViewingParameters(const float viewPlaneHeight) {
	topLimit = fabs(viewPlaneHeight) / 2.0f;

	rightLimit = topLimit * ((float)colorBuffer.getWindowWidth() / colorBuffer.getWindowHeight()); // Set r based on aspect ratio and height of plane

	// Make view plane symetrical about the viewing direction
	leftLimit = -rightLimit;
	bottomLimit = -topLimit;

	// Calculate the distance between pixels in the horizontal and vertical directions
	nx = (float)colorBuffer.getWindowWidth();
	ny = (float)colorBuffer.getWindowHeight();

	distToPlane = 0.0; // Rays start on the view plane

} // end calculateOrthographicViewingParameters

glm::vec2 RayTracer::getProjectionPlaneCoordinates(const float x, const float y) {
	// Page 75
	// Calculate and return the u and v data members as the x an y coordinates
	// of the 
	glm::vec2 uvScalarValues;
	uvScalarValues.x = leftLimit + (rightLimit - leftLimit) * (x + 0.5f) / nx;
	uvScalarValues.y = bottomLimit + (topLimit - bottomLimit) * (y + 0.5f) / ny;
	// TODO
	return uvScalarValues;
}

void RayTracer::setOrthoRayOriginAndDirection(const int x, const int y) {
	glm::vec2 uv = getProjectionPlaneCoordinates(x + 0.0f, y + 0.0f);

	// Page 75
	rayDirection = glm::normalize(-w);
	rayOrigin = eye + uv.x * u + uv.y * v;

} // end setOrthoOriginAndDirection

void RayTracer::setPerspectiveRayOriginAndDirection(const float x, const float y) {
	glm::vec2 uv = getProjectionPlaneCoordinates(x, y);
	rayDirection = glm::normalize(-distToPlane*w + uv.x*u + uv.y*v);
	rayOrigin = eye;
} // end setPerspectiveOriginAndDirection

void RayTracer::setAntiAliasingLevel(int l)
{
	antiAliasingLevel = l;
}

void RayTracer::setLight(PositionalLight l)
{
	light = l;
}

void RayTracer::raytraceScene1(const std::vector<std::shared_ptr<Surface>> & surfaces, const std::vector<std::shared_ptr<LightSource>> & lights) {
	this->surfacesInScene = surfaces;
	this->lightsInScene = lights;
	for (int x = 0; x < colorBuffer.getWindowWidth()/2; x++) {
		for (int y = 0; y < colorBuffer.getWindowHeight(); y++) {
			color total(0, 0, 0, 0);

			for (float row = -(antiAliasingLevel - 1); row <= antiAliasingLevel - 1; row++) {
				for (float col = -(antiAliasingLevel - 1); col <= antiAliasingLevel - 1; col++) {
					setPerspectiveRayOriginAndDirection(x - 0.5f + row/antiAliasingLevel, y - 0.5f + col/antiAliasingLevel);
					color C = traceIndividualRay(rayOrigin, rayDirection, 1);
					total = total + C;
				}
			}
			total /= (antiAliasingLevel * antiAliasingLevel);


			colorBuffer.setPixel(x, y, total);
		}
	}
	// Iterate through each and every pixel in the rendering window
	// TODO


} // end raytraceScene

void RayTracer::raytraceScene2(const std::vector<std::shared_ptr<Surface>> & surfaces, const std::vector<std::shared_ptr<LightSource>> & lights) {
	this->surfacesInScene = surfaces;
	this->lightsInScene = lights;
	for (int x = (colorBuffer.getWindowWidth()/2); x < colorBuffer.getWindowWidth(); x++) {
		for (int y = 0; y < colorBuffer.getWindowHeight(); y++) {
			color total(0, 0, 0, 0);

			for (float row = -(antiAliasingLevel - 1); row <= antiAliasingLevel - 1; row++) {
				for (float col = -(antiAliasingLevel - 1); col <= antiAliasingLevel - 1; col++) {
					setPerspectiveRayOriginAndDirection(x - 0.5f + row / antiAliasingLevel, y - 0.5f + col / antiAliasingLevel);
					color C = traceIndividualRay(rayOrigin, rayDirection, 1);
					total = total + C;
				}
			}
			total /= (antiAliasingLevel * antiAliasingLevel);


			colorBuffer.setPixel(x, y, total);
		}
	}
	// Iterate through each and every pixel in the rendering window
	// TODO


} // end raytraceScene

color RayTracer::traceIndividualRay(const glm::vec3 &e, const glm::vec3 &d, int recursionLevel) {
	// Find surface intersection that is closest to 'e' in the direction 'd.'
	// TODO
	float distance = FLT_MAX;
	color result = defaultColor;
	HitRecord intersection;
	for (unsigned int i = 0; i < surfacesInScene.size(); i++) {
		HitRecord hit = surfacesInScene[i]->findClosestIntersection(e, d);
		if (hit.t != FLT_MAX && hit.t < distance) {
			distance = hit.t;
			result = hit.material;
			intersection = hit;
		}
	}
	if (intersection.t != FLT_MAX ) {
		float eps = 0.005f;
		glm::vec3 origin = intersection.interceptPoint + (intersection.surfaceNormal * eps);

		for (unsigned int j = 0; j < surfacesInScene.size(); j++) {
			HitRecord hit = surfacesInScene[j]->findClosestIntersection(origin , light.lightPosition - origin);
			if (hit.t <= 1 && hit.t != FLT_MAX && hit.t > 0 ) {
				return color(0, 0, 0, 1);
			}
		}
	}

	return result;

} // end traceRay


