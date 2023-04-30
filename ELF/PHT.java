package event.elf;

import java.util.stream.Stream;

public enum PHT {
    NULL(0x00000000),
    LOAD(0x00000001),
    DYNAMIC(0x00000002),
    INTERP(0x00000003),
    NOTE(0x00000004),
    SHLIB(0x00000005),
    PHDR(0x00000006),
    TLS(0x00000007),
    LOOS(0x60000000),
    HIOS(0x6FFFFFFF),
    LOPROC(0x70000000),
    HIPROC(0x7FFFFFFF);

    private final int code;

    PHT(int code) {
        this.code = code;
    }

    public static PHT valueOf(int code) {
        return Stream.of(PHT.values())
                .filter(i -> i.code == code)
                .findFirst()
                .orElse(null);
    }
}
