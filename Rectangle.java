class Rectangle {
    int width, height;

    public Rectangle(int w, int h) {
        width = w;
        height = h;
    }

    @Override
    public boolean equals(Object obj) {
        // Check if the object is the same reference
        if (this == obj) return true;

        // Check if obj is null or not a Rectangle
        if (obj == null || !(obj instanceof Rectangle)) return false;

        // Cast to Rectangle
        Rectangle rect = (Rectangle) obj;

        // Compare width and height
        return this.width == rect.width && this.height == rect.height;
    }
    
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 10);
        Rectangle r2 = new Rectangle(15, 10);
        Rectangle r3 = new Rectangle(5, 10);

        System.out.println(r1.equals(r2)); // false
        System.out.println(r1.equals(r3)); // true
    }
}