package com.example

import org.gradle.api.Plugin
import org.gradle.api.Project

class HelloWorldPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task('hello') << {
            println "Hello, world"
        }
    }
}

