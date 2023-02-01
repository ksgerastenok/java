interface Draw {

}
class OpenGL implements Draw {

}
class Vulcan implements Draw {

}

interface Serialize {

}
class XML implements Serialize {

}
class JSON implements Serialize {

}

interface Shape {
    <T extends Draw> void draw(Class<T> strategy);
    <T extends Serialize> T serialize(Class<T> strategy);
}
class Triangle implements Shape {
    public <T extends Draw> void draw(Class<T> type) {
        if (OpenGL.class.equals(type)) {
            this.drawOpenGL();
        } else if (Vulcan.class.equals(type)) {
            this.drawVulkan();
        } else {
            this.drawDefault();
        }
    }
    private void drawOpenGL() {
        System.out.println("Triangle.draw(): OpenGL");
    }
    private void drawVulkan() {
        System.out.println("Triangle.draw(): Vulcan");
    }
    private void drawDefault() {
        System.out.println("Triangle.draw(): Unsupported strategy");
    }

    public <T extends Serialize> T serialize(Class<T> type) {
        if (XML.class.equals(type)) {
            return type.cast(this.serializeXML());
        } else if (JSON.class.equals(type)) {
            return type.cast(this.serializeJSON());
        } else {
            return type.cast(this.serializeDefault());
        }
    }
    private XML serializeXML() {
        System.out.println("Triangle.serialize(): XML");
        return XML();
    }
    private JSON serializeJSON() {
        System.out.println("Triangle.serialize(): JSON");
        return JSON();
    }
    private Serialize serializeDefault() {
        System.out.println("Triangle.serialize(): Unsupported strategy");
        return null;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        Shape shape = new Triangle();
        JSON data = shape.serialize(JSON.class);
        shape.draw(OpenGL.class);
        System.out.println(data);
    }
}
