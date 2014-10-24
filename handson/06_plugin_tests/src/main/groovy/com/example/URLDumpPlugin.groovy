package com.example

import org.gradle.api.Plugin
import org.gradle.api.Project

class URLDumpPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create("urldump", URLDumpPluginExtension)

        project.task('dumpURL') << {
            URLDumper.dump(project.urldump.url, project.file(project.urldump.dumpFile))
        }
    }
}

class URLDumper {

    static dump(String url, File dumpFile) {
        new URL(url).withInputStream { is->
            dumpFile.withOutputStream { os->
                os << is
            }
        }
    }

}

class URLDumpPluginExtension {
    String url
    def dumpFile
}

