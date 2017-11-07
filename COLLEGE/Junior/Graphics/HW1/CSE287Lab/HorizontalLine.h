#pragma once

#include "FrameBuffer.h"
#include "BasicIncludesAndDefines.h"

class HorizontalLine {

private:
	int leftX, rightX;
	int y;
public:
	HorizontalLine(int lx, int rx, int Y);
	void draw(FrameBuffer &fb, color C);
};