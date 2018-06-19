float x;
float y;
float w;
float h;
int col = 0;

int red = 0;
int green = 0;
int blue = 0;

void setup() {
  frameRate( 30 );
  size(1200, 600);
  background(255);
  spiral();
}

void spiral() {

  x = 600;
  y = 300;
  w = 595;
  h = 595;

  //spiralRecur(x, y, w, h, 0);
}

void draw() {
  spiralRecur(x, y, w, h, 0);
}

void spiralRecur(float x, float y, float w, float h, int grad) {


  noStroke();
  fill( red + grad, 0, blue + grad );
  ellipse( x, y, w, h);  

  if ( h > 5) {

    float w2 = w - 5;
    float h2 = h - 5;
    grad = grad + 2;
    spiralRecur( x, y, w2, h2, grad );
  }
}

void mouseMoved() {

  if ( mouseX > width / 2 ) {
    red = red + 3;
    blue = blue + 3;
    if ( red > 255 ) {
      red = 255;
      blue = 255;
    }
  } else {
    red = red - 3;
    blue = blue - 3;
    if ( red < 0 ) {
      red = 0;
      blue = 0;
    }
  }
}