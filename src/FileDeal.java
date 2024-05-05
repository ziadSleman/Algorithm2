import java.io.*;
import java.util.ArrayList;
public class FileDeal {
    public FileDeal() {
    }

    public static void createFile(String Path, String fileName, String content) {
        try {
            File file = new File( Path, fileName);
            FileWriter fw = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            bufferedWriter.write(content);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createNestedFolders(String fullPath) {
        File currentFolder = new File( fullPath);
        if (!currentFolder.exists()) {
            boolean created = currentFolder.mkdirs();
            if (created) {
                System.out.println(" The folder has been created : " + currentFolder.getAbsolutePath());
            } else {
                System.out.println(" Failed to create folder : " + currentFolder.getAbsolutePath());
            }
        } else {
            System.out.println(" The folder already exists : " + currentFolder.getAbsolutePath());
        }
    }
    public static ArrayList<String[]> readStr(String path) throws FileNotFoundException {
        ArrayList<String[]> all = new ArrayList<>();
        String[] line;
        BufferedReader in;
        File f = new File(path);
        FileReader fileReader = new FileReader(f);
        try {
            in = new BufferedReader(fileReader);
            String string;
            while (in.read() != -1) {
                string = in.readLine();
                line = new String[]{string};
                all.add(line);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return all;
    }
}