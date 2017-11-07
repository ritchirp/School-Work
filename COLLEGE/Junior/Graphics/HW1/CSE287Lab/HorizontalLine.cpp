#include "HorizontalLine.h"

HorizontalLine::HorizontalLine(int lx, int rx, int Y) {
	leftX = lx;
	rightX = rx;
	y = Y;
}


void HorizontalLine::draw(FrameBuffer &fb, color C) {
	for (int i = leftX; i <= rightX; i++) {
		fb.setPixel(i, y, C);
	}
}