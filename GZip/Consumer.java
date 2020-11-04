package event.gzip;

import java.nio.channels.*;

public interface Consumer {
    public void process(FileChannel channel, Data data) throws Exception;
}
