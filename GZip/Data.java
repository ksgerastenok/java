package event.gzip;

public class Data extends Object {
    private byte[] data;
    private long position;

    public Data() {
        super();

        this.setPosition(0);
        this.setData(null);

        return;
    }

    public void setPosition(long position) {
        this.position = position;

        return;
    }

    public long getPosition() {
        return (this.position);
    }

    public int getLength() {
        return (this.data.length);
    }

    public void setData(byte[] data) {
        this.data = data;

        return;
    }

    public byte[] getData() {
        return (this.data);
    }
}
