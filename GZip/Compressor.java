package event.gzip;

import java.io.*;
import java.nio.channels.*;
import java.util.zip.*;

public class Compressor extends Object {
    private GZip gzip;

    public Compressor() {
        this.gzip = new GZip(this::worker, this::consumer, this::producer);

        return;
    }

    public void process(String input, String output) throws Exception {
        this.gzip.process(input, output);

        return;
    }

    private void consumer(FileChannel channel, Data data) throws Exception {
        data.setPosition(Utils.ChannelPosition(channel));
        data.setData(Utils.ChannelReadBytes(channel, 1048576));

        return;
    }

    private void worker(Data data) throws Exception {
        try (ByteArrayInputStream stream1 = new ByteArrayInputStream(data.getData())) {
            try (ByteArrayOutputStream stream2 = new ByteArrayOutputStream()) {
                try (GZIPOutputStream stream3 = new GZIPOutputStream(stream2)) {
                    for (int i = stream1.read(); i != -1; i = stream1.read()) {
                        stream3.write(i);
                    }
                }
                data.setPosition(data.getPosition());
                data.setData(stream2.toByteArray());
            }
        }

        return;
    }

    private void producer(FileChannel channel, Data data) throws Exception {
        Utils.ChannelSeek(channel, Utils.ChannelPosition(channel));
        Utils.ChannelWriteLong(channel, data.getPosition());
        Utils.ChannelWriteInt(channel, data.getLength());
        Utils.ChannelWriteBytes(channel, data.getData());

        return;
    }
}
