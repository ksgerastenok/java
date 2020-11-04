package event.gzip;

import java.io.*;
import java.nio.channels.*;
import java.util.zip.*;

public class Decompressor extends Object {
    private GZip gzip;

    public Decompressor() {
        this.gzip = new GZip(this::worker, this::consumer, this::producer);

        return;
    }

    public void process(String input, String output) throws Exception {
        this.gzip.process(input, output);

        return;
    }

    private void consumer(FileChannel channel, Data data) throws Exception {
        data.setPosition(Utils.ChannelReadLong(channel));
        data.setData(Utils.ChannelReadBytes(channel, Utils.ChannelReadInt(channel)));

        return;
    }

    private void worker(Data data) throws Exception {
        try (ByteArrayInputStream stream1 = new ByteArrayInputStream(data.getData())) {
            try (ByteArrayOutputStream stream2 = new ByteArrayOutputStream()) {
                try (GZIPInputStream stream3 = new GZIPInputStream(stream1)) {
                    for (int i = stream3.read(); i != -1; i = stream3.read()) {
                        stream2.write(i);
                    }
                }
                data.setPosition(data.getPosition());
                data.setData(stream2.toByteArray());
            }
        }

        return;
    }

    private void producer(FileChannel channel, Data data) throws Exception {
        Utils.ChannelSeek(channel, data.getPosition());
        Utils.ChannelWriteBytes(channel, data.getData());

        return;
    }
}
