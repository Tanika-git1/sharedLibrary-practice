def call(Map config) {

    pipeline {
        agent any

        tools {
            maven "${config.maventool}"
        }

        stages {

            stage('Checkout') {
                steps {
                    git branch: config.branch, url: config.repourl
                }
            }

            stage('Build') {
                steps {
                    sh "mvn ${config.mavencommand}"
                }
            }// stages closing
        }//pipeline closing
    } //def closing
}
