Pacman p;
void setup() {
  size(600,600);
  p = new Pacman();
}
void draw() {
  clear();
  p.draw();
  
  if (p.getXLocation() < width - 40) {
    p.move();
  }
}
