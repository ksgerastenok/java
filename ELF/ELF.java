package event.elf;

import java.io.RandomAccessFile;

public class ELF {
    public final EH eh;
    public final PH[] ph;
    public final SH[] sh;

    public ELF(String fileName) throws Exception {
        try (RandomAccessFile file = new RandomAccessFile(fileName, "r")) {
            this.eh = new EH();
            this.eh.elf = file.readInt();
            this.eh.format = FORMAT.valueOf(file.readByte());
            this.eh.endian = ENDIAN.valueOf(file.readByte());
            this.eh.elfVersion = file.readByte();
            this.eh.abi = ABI.valueOf(file.readByte());
            this.eh.abiVersion = file.readByte();
            this.eh.pad = new byte[7];
            file.read(this.eh.pad);
            if (this.eh.format == FORMAT.x32) {
                if (this.eh.endian == ENDIAN.LITTLE) {
                    this.eh.type = EHT.valueOf(Short.reverseBytes(file.readShort()));
                    this.eh.machine = Short.reverseBytes(file.readShort());
                    this.eh.version = Integer.reverseBytes(file.readInt());
                    this.eh.entry = Integer.reverseBytes(file.readInt());
                    this.eh.phOffset = Integer.reverseBytes(file.readInt());
                    this.eh.shOffset = Integer.reverseBytes(file.readInt());
                    this.eh.flags = Integer.reverseBytes(file.readInt());
                    this.eh.elfSize = Short.reverseBytes(file.readShort());
                    this.eh.phSize = Short.reverseBytes(file.readShort());
                    this.eh.phNum = Short.reverseBytes(file.readShort());
                    this.eh.shSize = Short.reverseBytes(file.readShort());
                    this.eh.shNum = Short.reverseBytes(file.readShort());
                    this.eh.shStrIdx = Short.reverseBytes(file.readShort());
                }
                if (this.eh.endian == ENDIAN.BIG) {
                    this.eh.type = EHT.valueOf(file.readShort());
                    this.eh.machine = file.readShort();
                    this.eh.version = file.readInt();
                    this.eh.entry = file.readInt();
                    this.eh.phOffset = file.readInt();
                    this.eh.shOffset = file.readInt();
                    this.eh.flags = file.readInt();
                    this.eh.elfSize = file.readShort();
                    this.eh.phSize = file.readShort();
                    this.eh.phNum = file.readShort();
                    this.eh.shSize = file.readShort();
                    this.eh.shNum = file.readShort();
                    this.eh.shStrIdx = file.readShort();
                }
            }
            if (this.eh.format == FORMAT.x64) {
                if (this.eh.endian == ENDIAN.LITTLE) {
                    this.eh.type = EHT.valueOf(Short.reverseBytes(file.readShort()));
                    this.eh.machine = Short.reverseBytes(file.readShort());
                    this.eh.version = Integer.reverseBytes(file.readInt());
                    this.eh.entry = Long.reverseBytes(file.readLong());
                    this.eh.phOffset = Long.reverseBytes(file.readLong());
                    this.eh.shOffset = Long.reverseBytes(file.readLong());
                    this.eh.flags = Integer.reverseBytes(file.readInt());
                    this.eh.elfSize = Short.reverseBytes(file.readShort());
                    this.eh.phSize = Short.reverseBytes(file.readShort());
                    this.eh.phNum = Short.reverseBytes(file.readShort());
                    this.eh.shSize = Short.reverseBytes(file.readShort());
                    this.eh.shNum = Short.reverseBytes(file.readShort());
                    this.eh.shStrIdx = Short.reverseBytes(file.readShort());
                }
                if (this.eh.endian == ENDIAN.BIG) {
                    this.eh.type = EHT.valueOf(file.readShort());
                    this.eh.machine = file.readShort();
                    this.eh.version = file.readInt();
                    this.eh.entry = file.readLong();
                    this.eh.phOffset = file.readLong();
                    this.eh.shOffset = file.readLong();
                    this.eh.flags = file.readInt();
                    this.eh.elfSize = file.readShort();
                    this.eh.phSize = file.readShort();
                    this.eh.phNum = file.readShort();
                    this.eh.shSize = file.readShort();
                    this.eh.shNum = file.readShort();
                    this.eh.shStrIdx = file.readShort();
                }
            }
            this.ph = new PH[this.eh.phNum];
            file.seek(this.eh.phOffset);
            for (int i = 0; i != this.ph.length; i += 1) {
                this.ph[i] = new PH();
                if (this.eh.format == FORMAT.x32) {
                    if (this.eh.endian == ENDIAN.LITTLE) {
                        this.ph[i].type = PHT.valueOf(Integer.reverseBytes(file.readInt()));
                        this.ph[i].offset = Integer.reverseBytes(file.readInt());
                        this.ph[i].vAddr = Integer.reverseBytes(file.readInt());
                        this.ph[i].pAddr = Integer.reverseBytes(file.readInt());
                        this.ph[i].size = Integer.reverseBytes(file.readInt());
                        this.ph[i].memSize = Integer.reverseBytes(file.readInt());
                        this.ph[i].flags = Integer.reverseBytes(file.readInt());
                        this.ph[i].align = Integer.reverseBytes(file.readInt());
                    }
                    if (this.eh.endian == ENDIAN.BIG) {
                        this.ph[i].type = PHT.valueOf(file.readInt());
                        this.ph[i].offset = file.readInt();
                        this.ph[i].vAddr = file.readInt();
                        this.ph[i].pAddr = file.readInt();
                        this.ph[i].size = file.readInt();
                        this.ph[i].memSize = file.readInt();
                        this.ph[i].flags = file.readInt();
                        this.ph[i].align = file.readInt();
                    }
                }
                if (this.eh.format == FORMAT.x64) {
                    if (this.eh.endian == ENDIAN.LITTLE) {
                        this.ph[i].type = PHT.valueOf(Integer.reverseBytes(file.readInt()));
                        this.ph[i].flags = Integer.reverseBytes(file.readInt());
                        this.ph[i].offset = Long.reverseBytes(file.readLong());
                        this.ph[i].vAddr = Long.reverseBytes(file.readLong());
                        this.ph[i].pAddr = Long.reverseBytes(file.readLong());
                        this.ph[i].size = Long.reverseBytes(file.readLong());
                        this.ph[i].memSize = Long.reverseBytes(file.readLong());
                        this.ph[i].align = Long.reverseBytes(file.readLong());
                    }
                    if (this.eh.endian == ENDIAN.BIG) {
                        this.ph[i].type = PHT.valueOf(file.readInt());
                        this.ph[i].flags = file.readInt();
                        this.ph[i].offset = file.readLong();
                        this.ph[i].vAddr = file.readLong();
                        this.ph[i].pAddr = file.readLong();
                        this.ph[i].size = file.readLong();
                        this.ph[i].memSize = file.readLong();
                        this.ph[i].align = file.readLong();
                    }
                }
            }
            this.sh = new SH[this.eh.shNum];
            file.seek(this.eh.shOffset);
            for (int i = 0; i != this.sh.length; i += 1) {
                this.sh[i] = new SH();
                if (this.eh.format == FORMAT.x32) {
                    if (this.eh.endian == ENDIAN.LITTLE) {
                        this.sh[i].name = Integer.reverseBytes(file.readInt());
                        this.sh[i].type = SHT.valueOf(Integer.reverseBytes(file.readInt()));
                        this.sh[i].flags = Integer.reverseBytes(file.readInt());
                        this.sh[i].addr = Integer.reverseBytes(file.readInt());
                        this.sh[i].offset = Integer.reverseBytes(file.readInt());
                        this.sh[i].size = Integer.reverseBytes(file.readInt());
                        this.sh[i].link = Integer.reverseBytes(file.readInt());
                        this.sh[i].info = Integer.reverseBytes(file.readInt());
                        this.sh[i].align = Integer.reverseBytes(file.readInt());
                        this.sh[i].entSize = Integer.reverseBytes(file.readInt());
                    }
                    if (this.eh.endian == ENDIAN.BIG) {
                        this.sh[i].name = file.readInt();
                        this.sh[i].type = SHT.valueOf(file.readInt());
                        this.sh[i].flags = file.readInt();
                        this.sh[i].addr = file.readInt();
                        this.sh[i].offset = file.readInt();
                        this.sh[i].size = file.readInt();
                        this.sh[i].link = file.readInt();
                        this.sh[i].info = file.readInt();
                        this.sh[i].align = file.readInt();
                        this.sh[i].entSize = file.readInt();
                    }
                }
                if (this.eh.format == FORMAT.x64) {
                    if (this.eh.endian == ENDIAN.LITTLE) {
                        this.sh[i].name = Integer.reverseBytes(file.readInt());
                        this.sh[i].type = SHT.valueOf(Integer.reverseBytes(file.readInt()));
                        this.sh[i].flags = Long.reverseBytes(file.readLong());
                        this.sh[i].addr = Long.reverseBytes(file.readLong());
                        this.sh[i].offset = Long.reverseBytes(file.readLong());
                        this.sh[i].size = Long.reverseBytes(file.readLong());
                        this.sh[i].link = Integer.reverseBytes(file.readInt());
                        this.sh[i].info = Integer.reverseBytes(file.readInt());
                        this.sh[i].align = Long.reverseBytes(file.readLong());
                        this.sh[i].entSize = Long.reverseBytes(file.readLong());
                    }
                    if (this.eh.endian == ENDIAN.BIG) {
                        this.sh[i].name = file.readInt();
                        this.sh[i].type = SHT.valueOf(file.readInt());
                        this.sh[i].flags = file.readLong();
                        this.sh[i].addr = file.readLong();
                        this.sh[i].offset = file.readLong();
                        this.sh[i].size = file.readLong();
                        this.sh[i].link = file.readInt();
                        this.sh[i].info = file.readInt();
                        this.sh[i].align = file.readLong();
                        this.sh[i].entSize = file.readLong();
                    }
                }
            }

            for (int i = 0; i != this.ph.length; i += 1) {
                this.ph[i].content = new byte[(int) this.ph[i].size];
                file.seek(this.ph[i].offset);
                file.read(this.ph[i].content);
            }
            for (int i = 0; i != this.sh.length; i += 1) {
                this.sh[i].content = new byte[(int) this.sh[i].size];
                file.seek(this.sh[i].offset);
                file.read(this.sh[i].content);
            }
        }
    }
}
