import java.util.*;
import java.util.stream.*;

//class Folder extends Object {
//    private Long size;
//    private final String full;
//    private final String name;
//    private final Folder parent;
//    private final Set<File> files;
//    private final Set<Folder> folders;
//
//    public Folder(String name, Folder parent) {
//        this.full = (parent != null) ? parent.getFullName() + "/" + name : name;
//        this.size = 0L;
//        this.name = name;
//        this.parent = parent;
//        this.files = new HashSet<>();
//        this.folders = new HashSet<>();
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
//    public Long getSize() {
//        return this.size;
//    }
//
//    public void delete() {
//        for (File file : this.files) {
//            file.delete();
//        }
//        //this.files.clear();
//
//        for (Folder folder : this.folders) {
//            folder.delete();
//        }
//        //this.folders.clear();
//
//        if (this.parent != null) {
//            this.parent.removeFolder(this);
//        }
//
//        System.out.println("Folder " + this.full + " has been deleted.");
//    }
//
//    void removeFolder(Folder folder) {
//        this.folders.remove(folder);
//    }
//
//    void removeFile(File file) {
//        this.files.remove(file);
//    }
//
//    public void addFolder(String name) {
//        this.folders.add(new Folder(name, this));
//    }
//
//    public void addFile(String name) {
//        this.files.add(new File(name, this));
//    }
//
//    public Set<Folder> getFolders() {
//        return Collections.unmodifiableSet(this.folders);
//    }
//
//    public Set<File> getFiles() {
//        return Collections.unmodifiableSet(this.files);
//    }
//
//    public Folder toFolder(String name) {
//        return this.folders.stream()
//            .filter(s -> s.getName().equals(name))
//            .findFirst()
//            .orElse(null);
//    }
//
//    public File toFile(String name) {
//        return this.files.stream()
//            .filter(s -> s.getName().equals(name))
//            .findFirst()
//            .orElse(null);
//    }
//
//    public void update(Long delta) {
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
//        System.out.println("File " + this.full + " has been deleted.");
//    }
//}

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
