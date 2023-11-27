package ru.geekbrains.jc.hw.fifth;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;


import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class BackupApp {
    public static void main(String[] args){
        File pathFrom = new File ("/Users/Mikle/Downloads/GeekBrains/Java_Core/hw/src/main/java/ru/geekbrains/jc/hw/");
        File pathTo = new File("backup");
        pathTo.mkdir();
        backupFiles(pathFrom.getAbsolutePath(), pathTo.getAbsolutePath());


    }
    public static void makeDir(String fileName) {
        File file = new File(fileName);
        if(file.mkdir());
    }
    public static void backupFiles(String fromFolder, String toFolder){
        File from = new File(fromFolder);
        if (!from.exists()){
            System.out.println("No such directory");
        }else {
            File to = new File(toFolder);
            if (to.mkdir());
            File [] listFiles = from.listFiles();
            for (File file : listFiles) {
                if (file.isDirectory()){
                    System.out.println(file.getAbsolutePath() + " is Directory");
                    backupFiles(file.getAbsolutePath(), toFolder);
                } else if (file.isFile()) {
                    System.out.println(file.getName());

                }

            }
        }
    }
}
