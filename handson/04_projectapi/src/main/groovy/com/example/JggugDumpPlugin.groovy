package com.example

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * プロジェクトディレクトリの「jggug.txt」にhttp://www.jggug.org/のテキストをダウンロードする
 *
 * プロジェクトAPIは以下を参照する
 * http://www.gradle.org/docs/current/dsl/org.gradle.api.Project.html
 */
class JggugDumpPlugin implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.task('dumpJggug') << {
            new URL("http://www.jggug.org/").withInputStream { is->
                def downloadFile = 
                downloadFile.withOutputStream { os->
                    os << is
                }
            }
        }
    }
}

