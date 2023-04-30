package event.elf;

import java.util.stream.Stream;

public enum SHT {
    NULL(0x00000000),
    PROGBITS(0x00000001),
    SYMTAB(0x00000002),
    STRTAB(0x00000003),
    RELA(0x00000004),
    HASH(0x00000005),
    DYNAMIC(0x00000006),
    NOTE(0x00000007),
    NOBITS(0x00000008),
    REL(0x00000009),
    SHLIB(0x0000000A),
    DYNSYM(0x0000000B),
    INIT(0x0000000E),
    FINI(0x0000000F),
    PREINIT(0x00000010),
    GROUP(0x00000011),
    SHNDX(0x00000012),
    NUM(0x00000013),
    LOOS(0x60000000);

    private final int code;

    SHT(int code) {
        this.code = code;
    }

    public static SHT valueOf(int code) {
        return Stream.of(SHT.values())
                .filter(i -> i.code == code)
                .findFirst()
                .orElse(null);
    }
}
