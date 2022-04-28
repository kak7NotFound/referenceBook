package org.me.main.util;

import lombok.SneakyThrows;
import org.me.main.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class FileUtility {
    public String readFile(String path) {
        try {
            InputStream is = getFileFromResourceAsStream(path);

            String text = new BufferedReader(
                    new InputStreamReader(is, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            return text;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public InputStream getFileFromResourceAsStream(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
    public static void printInputStream(InputStream is) {

        try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(streamReader)) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @SneakyThrows
    public ArrayList<String> getResourcesFromJar() {

        var pathList = new ArrayList<String>();

        var path = "articles";
        var jar = new JarFile(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        final Enumeration<JarEntry> entries = jar.entries();
        while (entries.hasMoreElements()) {
            var element = entries.nextElement();
            var name = element.getName();
            if (name.startsWith(path + "/")) {
                if (name.endsWith(".html")) {
                    pathList.add(name);
                }
            }
        }
        return pathList;
    }

    @SneakyThrows
    public ArrayList<String> getResourcesFromJar(String path) {

        var pathList = new ArrayList<String>();

        var jar = new JarFile(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        final Enumeration<JarEntry> entries = jar.entries();
        while (entries.hasMoreElements()) {
            var element = entries.nextElement();
            var name = element.getName();
            if (name.startsWith(path + "/")) {
                if (name.endsWith(".html")) {
                    pathList.add(name);
                }
            }
        }
        return pathList;
    }

    @SneakyThrows
    public ArrayList<String> getFolders(String path) {

        var pathList = new ArrayList<String>();

        var jar = new JarFile(Main.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        final Enumeration<JarEntry> entries = jar.entries();
        while (entries.hasMoreElements()) {
            var element = entries.nextElement();
            var name = element.getName();
            if (name.startsWith(path + "/")) {
                if (name.endsWith("html"))
                pathList.add(name);

            }
        }
        return pathList;
    }
}
