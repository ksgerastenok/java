package event.classic.handler;

public interface Execute<Sender, Event> {
    public void execute(Sender sender, Event event);
}
