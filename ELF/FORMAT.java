package event.elf;

import java.util.stream.Stream;

public enum FORMAT {
    x32((byte) 1),
    x64((byte) 2);

    private final byte code;

    FORMAT(byte code) {
        this.code = code;
    }

    public static FORMAT valueOf(byte code) {
        return Stream.of(FORMAT.values())
                .filter(i -> i.code == code)
                .findFirst()
                .orElse(null);
    }
}
