pipeline {
    options {
        ansiColor('xterm')
    }
    agent any
    stages {
        stage('Build Image') {
            steps {
                echo '==> build image ...'
                sh './gradlew clean'
                sh './gradlew bootBuildImage'
            }
        }
        stage('Push Image') {
            steps {
                script {
                    echo '==> push image ...'
                    def props = readProperties file: 'gradle.properties'
                    env.PROJECT_NAME = props['projectName']
                    env.PROJECT_VERSION = props['projectVersion']
                    withCredentials([string(credentialsId: 'DOCKER' ,variable:'SECRET')]) {
                        sh 'docker login -u feurle -p ${SECRET}'
                        sh 'docker push feurle/${PROJECT_NAME}:${PROJECT_VERSION}'
                    }
                }
            }
        }
    }
}