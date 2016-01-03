package com.github.badoualy.telegram.tl.builder

import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.util.*

fun File.recursiveFind(filter: (file: File) -> Boolean): List<File> {
    var res = ArrayList<File>()
    var stack = ArrayList<File>()
    stack.add(this)
    while (stack.size > 0) {
        var item = stack.removeAt(0);
        var files = item.listFiles()
        if (files != null) {
            for (f in files) {
                if (f.isDirectory) {
                    stack.add(f);
                }

                if (filter.invoke(f)) {
                    res.add(f)
                }
            }
        }
    }
    return res;
}

fun exec(command: String, workingFolder: String) {
    println(command);
    var process = Runtime.getRuntime().exec(command, null, File(workingFolder));
    var inStream = BufferedReader(InputStreamReader(process.errorStream!!));
    var line = inStream.readLine()
    while (line != null) {
        System.out.println(line);
        line = inStream.readLine()
    }
    inStream.close();
}

fun compileClasses(srcFolder: String, workingFolder: String, destFolder: String) {
    var args = "-g:vars -classpath " + File(".").absoluteFile + "/tl-core.jar -d " + destFolder + " ";

    var files = File(srcFolder).recursiveFind { x -> x.extension == "java" };

    for (f in files) {
        args += f.absolutePath + " ";
    }

    File(workingFolder + "/" + destFolder).mkdirs();
    exec("javac " + args, workingFolder);
}

fun buildJar(classesFolder: String, jarName: String, workingFolder: String) {
    var args = "";
    var files = File(workingFolder + "/" + classesFolder).recursiveFind { x -> x.extension == "class" };

    for (f in files) {
        args += f.absolutePath.substring(("$workingFolder/$classesFolder/").length) + " ";
    }

    exec("jar cf ../$jarName $args", "$workingFolder/$classesFolder/")
}