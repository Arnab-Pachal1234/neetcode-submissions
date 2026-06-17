
interface Shape {
    Shape clone();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public Shape clone() {
        Rectangle curr = new Rectangle(width,height);
        return curr;
    }
}

class Square implements Shape {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public Shape clone() {
        Square curr = new Square(length);
        return curr;
    }
}

class Test {
    public List<Shape> cloneShapes(List<Shape> shapes) {
      List<Shape> ans = new ArrayList<>();
      for(Shape s : shapes){
        ans.add(s.clone());
      }
      return ans;
    }
}
