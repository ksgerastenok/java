package event.elf;

public class EH {
    public int elf;
    public FORMAT format;
    public ENDIAN endian;
    public byte elfVersion;
    public ABI abi;
    public byte abiVersion;
    public byte[] pad;
    public EHT type;
    public short machine;
    public int version;
    public long entry;
    public long phOffset;
    public long shOffset;
    public int flags;
    public short elfSize;
    public short phSize;
    public short phNum;
    public short shSize;
    public short shNum;
    public short shStrIdx;
}
