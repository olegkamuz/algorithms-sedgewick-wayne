import java.io.File;

public class Exercise1343_ListingFiles {
    public static void main(String[] args) {
        File file = new File("/var/www");
        ListingFiles listingFiles = new ListingFiles();
        listingFiles.listFiles(file);
    }

}
