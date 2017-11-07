#include <string>
#include "BasicIncludesAndDefines.h"
#include "FrameBuffer.h"
#include "ScanConversion.h"

FrameBuffer colorBuffer(WINDOW_WIDTH, WINDOW_HEIGHT);
const int N = 50;
const int TIME_INTERVAL = 25;
int windowWidth, windowHeight;

std::vector<glm::vec3> triangleVertices = { glm::vec3(-2*N,2*N,1), glm::vec3(-N,2*N,1), glm::vec3(-1.5f*N,3*N,1) };
std::vector<glm::vec3> square1Vertices = { glm::vec3(0,0,1), glm::vec3(N,0,1),
											glm::vec3(N,N,1), glm::vec3(0,N,1) };
std::vector<glm::vec3> square2Vertices = { glm::vec3(3*N,-2*N,1), glm::vec3(3*N,-3*N,1),
											glm::vec3(2*N,-3*N,1), glm::vec3(2*N,-2*N,1) };
std::vector<glm::vec3> square3Vertices = { glm::vec3(-0.5*N, 3 * N, 1), glm::vec3(0.5*N, 3 * N, 1),
											glm::vec3(0.5*N, 4 * N, 1), glm::vec3(-0.5*N, 4 * N, 1) };

int displayedProblem = 0;

glm::mat3 T(float dx, float dy) {
	return glm::mat3(1, 0, 0, 0, 1, 0, dx, dy, 1);
}

glm::mat3 S(float sx, float sy) {
	return glm::mat3(sx, 0, 0, 0, sy, 0, 0, 0, 1);
}

glm::mat3 R(float deg) {
	float rad = glm::radians(deg);
	float cos = glm::cos(rad);
	float sin = glm::sin(rad);
	return glm::mat3(cos, sin, 0, -sin, cos, 0, 0, 0, 1);
}

glm::mat3 horzShear(float a) {
	return glm::mat3(1,0,0,a,1,0,0,0,1);
}

glm::mat3 vertShear(float a) {
	return glm::mat3(1, a, 0, 0, 1, 0, 0, 0, 1 );
}

// leave alone
std::vector<glm::vec3> transformVertices(const glm::mat3 &transMatrix, const std::vector<glm::vec3> &vertices) {
	std::vector<glm::vec3> transformedVertices;

	for (unsigned int i = 0; i < vertices.size(); i++) {
		glm::vec3 vt(transMatrix * vertices[i]);
		transformedVertices.push_back(vt);
	}

	return transformedVertices;
}

// leave alone
void drawAll(const glm::mat3 &TM) {
	std::vector<glm::vec3> triVertsTransformed = transformVertices(TM, triangleVertices);
	std::vector<glm::vec3> square1VerticesTransformed = transformVertices(TM, square1Vertices);
	std::vector<glm::vec3> square2VerticesTransformed = transformVertices(TM, square2Vertices);
	drawWirePolygon(triangleVertices, black);
	drawWirePolygon(square1Vertices, black);
	drawWirePolygon(square2Vertices, black);
	drawWirePolygon(triVertsTransformed, red);
	drawWirePolygon(square1VerticesTransformed, red);
	drawWirePolygon(square2VerticesTransformed, red);
	drawAxis();
}

void scaleBy2xOneHalf() {
	drawAll(S(2, 0.5));
}

void translate50_50() {
	drawAll(T(50, 50));
}

void rotate45() {
	drawAll(R(45));
}

void rotateNeg10() {
	drawAll(R(-10));
}

void reflectAcrossYaxis() {
	drawAll(S(-1,1));
}

void reflectAcrossXaxis() {
	drawAll(S(1, -1));
}

void reflectAcrossOrigin() {
	drawAll(S(-1, -1));
}

void scale2XAboutCenterOfTriangle() {
	glm::vec2 center((triangleVertices[0].x + triangleVertices[1].x) / 2, (triangleVertices[0].y + triangleVertices[2].y) / 2);
	drawAll(T(center.x, center.y) * S(2,2) * T(-center.x, -center.y));
}

void reflectAcrossLineYeqXplus50() {
	drawAll(T(0, 50) * R(45) * S(1,-1) * R(-45) * T(0, -50));
}

void reflectAcrossLineYeq2Xminus100() {
	float theta = glm::degrees(glm::atan(2));
	drawAll(T(0, -100) * R(theta) * S(1,-1) * R(-theta) * T(0, 100));
}

void animationOfRotationByAngle() {
	static float angle = 0.0f;
	angle += 1.0f;
	drawAll(R(angle));
}

void animationBounceSideToSide() {
	static float x = 0;
	x += 0.1f;
	drawAll(T(100*glm::sin(x), 0));
}

void horzShearOneHalf() {
	drawAll(horzShear(0.5f));
}

void vertShearOneHalf() {
	drawAll(vertShear(0.5));

}

void squareRotatingAroundOwnAxisAndAroundSun() {
	static float angle = 90.0f;
	angle++;
	glm::mat3 TM = R(angle)*T(0, 3.5 * N)*R(angle)*T(0, -3.5 * N);
	std::vector<glm::vec3> square3VerticesTransformed = transformVertices(TM, square3Vertices);
	drawWirePolygon(square3VerticesTransformed, black);

}

struct DisplayFunc {
	void(*f)();
	std::string name;
	DisplayFunc(void(*func)(), char *N) : f(func), name(N) {}
};

#define FUNC(F) DisplayFunc(F, #F)
std::vector<DisplayFunc> funcs = { FUNC(scaleBy2xOneHalf),
									FUNC(translate50_50),
									FUNC(rotate45),
									FUNC(rotateNeg10),
									FUNC(reflectAcrossYaxis),
									FUNC(reflectAcrossXaxis),
									FUNC(reflectAcrossOrigin),
									FUNC(scale2XAboutCenterOfTriangle),
									FUNC(reflectAcrossLineYeqXplus50),
									FUNC(reflectAcrossLineYeq2Xminus100),
									FUNC(animationOfRotationByAngle),
									FUNC(animationBounceSideToSide),
									FUNC(horzShearOneHalf),
									FUNC(vertShearOneHalf),
									FUNC(squareRotatingAroundOwnAxisAndAroundSun),
};

static void RenderSceneCB() {
	colorBuffer.clearColorAndDepthBuffers();
	(*funcs[displayedProblem].f)();				// call the correct function
	colorBuffer.showColorBuffer();
}

static void ResizeCB(int width, int height) {
	colorBuffer.setFrameBufferSize(width, height);
	windowWidth = width;
	windowHeight = height;
	glutPostRedisplay();
}

static void timer(int id) {
	glutTimerFunc(TIME_INTERVAL, timer, 0);
	glutPostRedisplay();
}

void problemMenu(int value) {
	if (value < (int)funcs.size()) {
		displayedProblem = value;
		glutSetWindowTitle(funcs[displayedProblem].name.c_str());
	} else {
		glutLeaveMainLoop();
	}
}

int main(int argc, char** argv) {
	glutInit(&argc, argv);

	glutInitDisplayMode(GLUT_RGBA | GLUT_SINGLE);
	glutInitWindowSize(WINDOW_WIDTH, WINDOW_HEIGHT);
	GLuint world_Window = glutCreateWindow("2D Transformations");

	glutSetOption(GLUT_ACTION_ON_WINDOW_CLOSE, GLUT_ACTION_GLUTMAINLOOP_RETURNS);

	glutDisplayFunc(RenderSceneCB);
	glutReshapeFunc(ResizeCB);
	glutTimerFunc(TIME_INTERVAL, timer, 0);

	int menu1id = glutCreateMenu(problemMenu);
	for (unsigned int i = 0; i < funcs.size(); i++) {
		glutAddMenuEntry(funcs[i].name.c_str(), i);
	}
	glutAddMenuEntry("Quit", funcs.size());
	glutAttachMenu(GLUT_RIGHT_BUTTON);

	colorBuffer.setClearColor(white);

	glutMainLoop();

	return 0;
}