package event.classic.handler;

import java.util.*;

public class EventHandler<Sender, Event> extends Object {
    private List<Execute<Sender, Event>> handler;

    public EventHandler() {
        super();

        this.handler = new ArrayList<>();

        return;
    }

    public void clear() {
        this.handler.clear();

        return;
    }

    public Boolean push(Execute<Sender, Event> handler) {
        return (this.handler.add(handler));
    }

    public Execute<Sender, Event> pop() {
        if((this.handler.size() == 0)) {
            return (null);
        }

        return (this.handler.remove(this.handler.size() - 1));
    }

    public Boolean remove(Execute<Sender, Event> handler) {
        return (this.handler.remove(handler));
    }

    public Execute<Sender, Event> remove(Integer i) {
        if (!((1 <= i) && (i <= this.handler.size()))) {
            return (null);
        }

        return (this.handler.remove(i - 1));
    }

    public Integer size() {
        return (this.handler.size());
    }

    public void execute(Sender sender, Event event) {
        for (Integer i = 0; (!(i.equals(this.handler.size()))); i += 1) {
            this.handler.get(i).execute(sender, event);
        }

        return;
    }
}
