package com.example

import org.gradle.api.Plugin
import org.gradle.api.Project

class JggugDumpPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task('dumpJggug') << {
            new URL("http://www.jggug.org/").withInputStream { is->
                project.file("jggug.txt").withOutputStream { os->
                    os << is
                }
            }
        }
    }
}

