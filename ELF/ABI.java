package event.elf;

import java.util.stream.Stream;

public enum ABI {
    SystemV((byte) 0x00),
    HPUX((byte) 0x01),
    NetBSD((byte) 0x02),
    Linux((byte) 0x03),
    Hurd((byte) 0x04),
    Solaris((byte) 0x06),
    AIX((byte) 0x07),
    IRIX((byte) 0x08),
    FreeBSD((byte) 0x09),
    Tru64((byte) 0x0A),
    Novell((byte) 0x0B),
    OpenBSD((byte) 0x0C),
    OpenVMS((byte) 0x0D),
    NonStop((byte) 0x0E),
    AROS((byte) 0x0F),
    FenixOS((byte) 0x10),
    Nuxi((byte) 0x11),
    OpenVOS((byte) 0x12);

    private final byte code;

    ABI(byte code) {
        this.code = code;
    }

    public static ABI valueOf(byte code) {
        return Stream.of(ABI.values())
                .filter(i -> i.code == code)
                .findFirst()
                .orElse(null);
    }
}
