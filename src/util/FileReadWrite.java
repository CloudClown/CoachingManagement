package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FileReadWrite {

    public boolean isFolderExist(String folderName) {
        File dir = new File(folderName);
        return dir.exists();
    }

    public boolean isFileExist(String fileName) {
        File dir = new File(fileName);
        return dir.exists();
    }

    public boolean createFolder(String folderName) {
        if (!folderName.isEmpty()) {
            File dir = new File(folderName);
            return dir.mkdir();
        } else {
            JOptionPane.showMessageDialog(null, "Folder name required!");
            return false;
        }

    }

    public boolean deleteFolder(String folderName) {
        if (!folderName.isEmpty()) {
            File dir = new File(folderName);
            return dir.delete();
        } else {
            JOptionPane.showMessageDialog(null, "Folder name required!");
            return false;
        }
    }

    public boolean createFile(String fileName) {
        if (!fileName.isEmpty()) {
            try{
                File file = new File(fileName);
                return file.createNewFile();
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "File can not be created!");
                return false;
            }
               
        } else {
            JOptionPane.showMessageDialog(null, "File name required!");
            return false;
        }

    }

    public boolean deleteFile(String fileName) {
        if (!fileName.isEmpty()) {
            File file = new File(fileName);
            return file.delete();
        } else {
            JOptionPane.showMessageDialog(null, "File name required!");
            return false;
        }
    }

    public String readFile(String fileName) {
        String data = "";
        try {
            File file = new File(fileName);

            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String singleData = scanner.next();
                data += singleData;

                System.out.println(singleData);
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Error occured while reading file.");
        }
        return data;
    }

    public boolean writeToFile(String fileAbsoluetePath, String data) {
        System.out.println("writeToFile=====>>>");
        System.out.println("fileAbsoluetePath: " + fileAbsoluetePath);
        System.out.println("newData: " + data);
        try {
            Formatter formatter = new Formatter(fileAbsoluetePath);
            formatter.format("%s", data);
            formatter.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getLocalizedMessage());
            return false;
        }

        return true;
    }
}
