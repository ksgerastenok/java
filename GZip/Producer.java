package event.gzip;

import java.nio.channels.*;

public interface Producer {
    public void process(FileChannel channel, Data data) throws Exception;
}
