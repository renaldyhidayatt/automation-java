import java.io.*;

public class FindFileWithExtension {
    private static final String fileLocation = "Pdf/";
    private static final String searchThisExtn = ".pdf";

    public static void main(String args[]){
        FindFileWithExtension obj = new FindFileWithExtension();

    }

    public void listFiles(String loc, String extn){
        SearchFiles files = new SearchFiles(extn);
        File folder = new File(loc);

        if(folder.isDirectory() == false){
            System.out.println("Folder does not exits" + fileLocation);
        }
        String[] list = folder.list();

        if(list.length == 0){
            System.out.println("There are no files with " + extn + " Extension");
            return;
        }

        for(String file: list){
            String temp = new StringBuffer(fileLocation).append(File.separator)
                    .append(file).toString();
            System.out.println("file : " + temp);
        }
    }

    public class SearchFiles implements FilenameFilter{
        private String ext;

        public SearchFiles(String ext){
            this.ext = ext;
        }

        public boolean accept(File loc, String name) {
            if(name.lastIndexOf('.')>0)
            {
                // get last index for '.'
                int lastIndex = name.lastIndexOf('.');

                // get extension
                String str = name.substring(lastIndex);
                System.out.println("Inside accept");
                // matching extension
                if(str.equalsIgnoreCase(ext))
                {
                    return true;
                }
            }
            return false;

        }
    }
}
