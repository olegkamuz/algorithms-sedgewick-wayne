import java.io.File;

public class ListingFiles {
    private Queue<String> queue;

    public ListingFiles() {
        this.queue = new Queue<>();
    }

    public void listFiles (File file) {
        check(file);
        print();
    }

    private void check(File file) {
        int indent = 0;
        if (file.isDirectory()) {
            add(file, indent);
            File[] files = file.listFiles();
            if(files != null) {
                for(File f: files)
                    check(f, indent);
            }
        } else add(file, indent);
    }


    private void check(File file, int indent) {
        indent++;
        if (file.isDirectory()) {
            add(file, indent);
            if(file.listFiles() != null) {
                for(File f: file.listFiles())
                    check(f, indent);
            }
        } else add(file, indent);
    }


    private void add(File file, int indent) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < indent; i++) {
            stringBuilder.append("   ");
        }
        stringBuilder.append(file.getName());
        queue.enqueue(stringBuilder.toString());
    }

    private void print() {
        StdOut.println();
        for (String s: queue) {
            StdOut.println(s);
        }
        StdOut.println();
    }
}
