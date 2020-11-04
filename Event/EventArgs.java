package event.classic;

public class EventArgs extends Object {
    private String name;

    public EventArgs() {
        super();

        this.name = String.valueOf("");

        return;
    }

    public String getName() {
        return (this.name);
    }

    public void setName(String value) {
        this.name = value;

        return;
    }
}
