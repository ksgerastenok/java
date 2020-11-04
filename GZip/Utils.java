package event.gzip;

import java.nio.*;
import java.nio.channels.*;

public final class Utils extends Object {
    private Utils() {
        return;
    }

    public static long ChannelPosition(FileChannel channel) throws Exception {
        return (channel.position());
    }

    public static long ChannelLength(FileChannel channel) throws Exception {
        return (channel.size());
    }

    public static long ChannelAvailable(FileChannel channel) throws Exception {
        return (channel.size() - channel.position());
    }

    public static byte[] ChannelReadBytes(FileChannel channel, int data) throws Exception {
        ByteBuffer result;

        result = ByteBuffer.allocate(Long.valueOf(Math.min(channel.size() - channel.position(), data)).intValue());
        channel.read(result);

        return (result.compact().array());
    }

    public static long ChannelReadLong(FileChannel channel) throws Exception {
        ByteBuffer result;

        result = ByteBuffer.allocate(Long.BYTES);
        channel.read(result);

        return (result.compact().getLong());
    }

    public static int ChannelReadInt(FileChannel channel) throws Exception {
        ByteBuffer result;

        result = ByteBuffer.allocate(Integer.BYTES);
        channel.read(result);

        return (result.compact().getInt());
    }

    public static void ChannelWriteBytes(FileChannel channel, byte[] data) throws Exception {
        channel.write(ByteBuffer.allocate(data.length).put(data).compact());
    }

    public static void ChannelWriteLong(FileChannel channel, long data) throws Exception {
        channel.write(ByteBuffer.allocate(Long.BYTES).putLong(data).compact());
    }

    public static void ChannelWriteInt(FileChannel channel, int data) throws Exception {
        channel.write(ByteBuffer.allocate(Integer.BYTES).putInt(data).compact());
    }

    public static void ChannelSeek(FileChannel channel, long position) throws Exception {
        channel.position(position);
    }
}
