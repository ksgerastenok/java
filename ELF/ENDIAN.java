package event.elf;

import java.util.stream.Stream;

public enum ENDIAN {
    LITTLE((byte) 1),
    BIG((byte) 2);

    private final byte code;

    ENDIAN(byte code) {
        this.code = code;
    }

    public static ENDIAN valueOf(byte code) {
        return Stream.of(ENDIAN.values())
                .filter(i -> i.code == code)
                .findFirst()
                .orElse(null);
    }
}
