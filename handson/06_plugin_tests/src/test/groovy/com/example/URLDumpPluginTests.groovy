package com.example;

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.After

import static org.junit.Assert.assertTrue;
import org.junit.Test;

class URLDumpPluginTests {

    def output = new File("dumptestfile.txt")

    @Test
    public void extensionObjectTest() {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: URLDumpPlugin

        // エクステンションオブジェクトの取得

        assertTrue(extension instanceof URLDumpPluginExtension)
    }

    @Test
    public void dumpURLTest() {
        URLDumper.dump("http://www.jggug.org/", output)

        assertTrue(output.length() > 0)
    }

    @After
    public void removeDumpfile() {
        if (output.exists()) {
            output.delete();
        }
    }
}
