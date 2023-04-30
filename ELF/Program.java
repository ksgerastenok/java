package event.elf;

import java.io.RandomAccessFile;

public class Program {
    public static void main(String[] args) throws Exception {
        ELF elf = new ELF("e:/bash");
        System.out.println(elf.eh.elf);
        System.out.println(elf.eh.format);
        System.out.println(elf.eh.endian);
        System.out.println(elf.eh.elfVersion);
        System.out.println(elf.eh.abi);
        System.out.println(elf.eh.abiVersion);
        System.out.println(elf.eh.type);
        System.out.println(elf.eh.machine);
        System.out.println(elf.eh.version);
        System.out.println(elf.eh.entry);
        System.out.println(elf.eh.elfSize);
        System.out.println(elf.eh.shSize);
        System.out.println(elf.eh.phSize);
        System.out.println(elf.eh.shNum);
        System.out.println(elf.eh.phNum);
        System.out.println(new String(elf.sh[elf.eh.shStrIdx].content));
        for (int i = 0; i != elf.ph.length; i += 1) {
            try (RandomAccessFile file = new RandomAccessFile("PH_" + i + "_" + elf.ph[i].type + ".bin", "rw")) {
                file.write(elf.ph[i].content);
            }
            System.out.println(elf.ph[i].type);
            System.out.println(elf.ph[i].flags);
            System.out.println(elf.ph[i].vAddr);
            System.out.println(elf.ph[i].pAddr);
            System.out.println(elf.ph[i].memSize);
            System.out.println(elf.ph[i].align);
        }

        for (int i = 0; i != elf.sh.length; i += 1) {
            StringBuilder name = new StringBuilder();
            for (int k = elf.sh[i].name; elf.sh[elf.eh.shStrIdx].content[k] != 0; k += 1) {
                name.append((char) elf.sh[elf.eh.shStrIdx].content[k]);
            }
            try (RandomAccessFile file = new RandomAccessFile("SH_" + i + "_" + elf.sh[i].type + name, "rw")) {
                file.write(elf.sh[i].content);
            }
            System.out.println(elf.sh[i].name);
            System.out.println(elf.sh[i].type);
            System.out.println(elf.sh[i].flags);
            System.out.println(elf.sh[i].addr);
            System.out.println(elf.sh[i].info);
            System.out.println(elf.sh[i].link);
            System.out.println(elf.sh[i].entSize);
            System.out.println(elf.sh[i].align);
        }
    }
}
