package event.classic;

public class EventUser extends Object {
    private EventCall call;

    public EventUser() {
        super();

        this.call = new EventCall();
        this.call.getEventHandler().push(this::call_Call);

        return;
    }

    private void call_Call(EventCall sender, EventArgs event) {
        System.out.println("Begin call_OnCall");
        System.out.println(event.getName());
        System.out.println("ClassName of event = " + event.getClass().getSimpleName());
        System.out.println("ClassName of sender = " + sender.getClass().getSimpleName());
        event.setName("hello from external method");
        System.out.println("End call_OnCall");

        return;
    }

    public void Execute() {
        this.call.PerformCall();

        return;
    }

    public static void main(String[] args) {
        new EventUser().Execute();

        return;
    }
}
