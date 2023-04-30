package event.elf;

import java.util.stream.Stream;

public enum EHT {
    NONE((short) 0x00),
    REL((short) 0x01),
    EXEC((short) 0x02),
    DYN((short) 0x03),
    CORE((short) 0x04),
    LOOS((short) 0xFE00),
    HIOS((short) 0xFEFF),
    LOPROC((short) 0xFF00),
    HIPROC((short) 0xFFFF);

    private final short code;

    EHT(short code) {
        this.code = code;
    }

    public static EHT valueOf(short code) {
        return Stream.of(EHT.values())
                .filter(i -> i.code == code)
                .findFirst()
                .orElse(null);
    }
}
