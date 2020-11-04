package event.classic;

import event.classic.handler.*;

public class EventCall extends Object {
    private EventArgs event;
    private EventHandler<EventCall, EventArgs> handler;

    public EventCall() {
        super();

        this.event = new EventArgs();
        this.handler = new EventHandler<>();

        return;
    }

    private void Call() {
        System.out.println("-------------------------------");
        this.event.setName("hello from internal method");
        System.out.println("Begin Handler");
        this.handler.execute(this, this.event);
        System.out.println("End Handler");
        System.out.println(this.event.getName());
        System.out.println("-------------------------------");

        return;
    }

    public EventHandler<EventCall, EventArgs> getEventHandler() {
        return (this.handler);
    }

    public void PerformCall() {
        this.Call();

        return;
    }
}
