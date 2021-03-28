import java.util.*;
import java.util.stream.*;



public void update(Long delta) {
//        if (this.parent != null) {
//            this.parent.update(delta);
//        }
//
//        this.size += delta;
//    }
//}
//
//class File extends Object {
//    private Long size;
//    private final String full;
//    private final String name;
//    private final Folder parent;
//
//    public File(String name, Folder parent) {
//        this.full = (parent != null) ? parent.getFullName() + "/" + name : name;
//        this.size = 0L;
//        this.name = name;
//        this.parent = parent;
//    }
//
//    public String getName() {
//        return this.name;
//    }
//
//    public String getFullName() {
//        return this.full;
//    }
//
//    public void setSize(Long size) {
//        if (this.parent != null) {
//            this.parent.update(size - this.size);
//        }
//
//        this.size = size;
//    }
//
//    public void delete() {
//        if (this.parent != null) {
//            this.parent.removeFile(this);
//        }
//

public class Program extends Object {
    private static List<Integer> getPrimes(int n) {
        for (int i = 1; i != Math.round(Math.sqrt(n)); i += 1) {
            if (n % (i + 1) == 0) {
                return Stream.of(Collections.singletonList(i + 1), getPrimes(n / (i + 1)))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
            }
        }

        return(Collections.singletonList(n));
    }

    public static void main(String[] args) {
        System.out.println(getPrimes(171));
//        Folder folder = new Folder("", null);
//        folder.addFolder("folder1");
//        folder.addFolder("folder2");
//        folder.addFolder("folder3");
//        folder.toFolder("folder1").addFolder("folder1");
//        folder.toFolder("folder1").addFolder("folder2");
//        folder.toFolder("folder1").addFile("file1");
//        folder.toFolder("folder1").toFile("file1").setSize(50L);
//        folder.toFolder("folder1").toFolder("folder1").addFile("file1");
//        folder.toFolder("folder1").toFolder("folder1").addFile("file2");
//        folder.toFolder("folder1").toFolder("folder1").toFile("file1").setSize(20L);
//        folder.toFolder("folder1").toFolder("folder1").toFile("file2").setSize(10L);
//        System.out.println(folder.toFolder("folder1").getSize());
//        System.out.println(folder.toFolder("folder1").toFolder("folder1").getSize());
//        System.out.println(folder.toFolder("folder1").toFolder("folder1").toFile("file1").getFullName());
//        folder.toFolder("folder1").delete();
    }
}
