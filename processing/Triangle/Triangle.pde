void setup() {
  
  size(600,600);
  background(255,255,255);
  fracTri( (width/2), 0, width );
}

void fracTri( int x, int y, int sl ) {
  
  int h = (int) Math.sqrt( (sl)*(sl) - (sl/2) *(sl/2) );
  
  // BIG!
  triangle( 
  x, y,  // TOP, CENTER
  x - (sl/2), h,  // BOTTOM, LEFT
  x + (sl/2), h   // BOTTOM, RIGHT
  );
  
  // FRACTURE
  if (sl > 3) {
    int newH = (int) Math.sqrt( (sl/2)*(sl/2) - (sl/4) *(sl/4) );
    fill( (int) (Math.random()*255), (int) (Math.random()*255), (int) (Math.random()*255) );
    fracTri(x, y, newH);
    // BOT, LEFT
    fracTri( x , y + newH, newH );
  }
}