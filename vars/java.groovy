def call(Map config) {

    pipeline {
        agent any

        tools {
            maven "${config.maventool}"
        }

        stages {

            stage('Checkout') {
                steps {
                    git branch: config.branch,
                        credentialsId: config.cred,
                        url: config.repourl
                }
            }

            stage('Build') {
                steps {
                    sh "mvn ${config.mavencommand}"
                }
            }
        }
    }
}
