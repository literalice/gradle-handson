package com.example

import org.gradle.api.Plugin
import org.gradle.api.Project

class URLDumpPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create("urldump", URLDumpPluginExtension)

        project.task('dumpURL') << {
            new URL(project.urldump.url).withInputStream { is->
                project.file(project.urldump.dumpFile).withOutputStream { os->
                    os << is
                }
            }
        }
    }
}

class URLDumpPluginExtension {
    String url
    def dumpFile
}

