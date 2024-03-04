package com.kkbapps.judge.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {

    /**
     * 将数据写入文件
     */
    public static File saveFile(String folderPath, String fileName, String content) {
        File fileFolder = new File(folderPath);
        // 如果文件夹不存在则创建
        if (!fileFolder.exists()) {
            fileFolder.mkdirs();
        }
        // 创建文件
        File file = new File(fileFolder, fileName);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println("文件保存失败：" + e.getMessage());
            throw new RuntimeException();
        }
        return fileFolder;
    }


    /**
     * 删除文件/文件夹
     */
    public static void delete(File folder) {
        if (folder.isDirectory()) {
            File[] files = folder.listFiles();
            if (files != null) {
                for (File file : files) {
                    delete(file);
                }
            }
        }
        folder.delete();
    }
}
