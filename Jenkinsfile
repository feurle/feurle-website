pipeline {
    options {
        ansiColor('xterm')
    }
    agent any
    environment {
        MY_KEY = 'MY_VALUE'
    }
    stages {
        stage("Env Build Number" ){
            steps{
                echo "The build number is ${env.BUILD_NUMBER}"
                echo "You can also use \${BUILD_NUMBER} -> ${BUILD_NUMBER}"

                echo "Host: ${env.DEPLOYMENT_HOST_TEST}"
                echo "Deployment host for TEST stage: \${DEPLOYMENT_HOST_TEST} -> ${DEPLOYMENT_HOST_TEST}"
            }
        }
        stage ("Read Properties") {
            steps {
                // Use a script block to do custom scripting
                script {
                    def props = readProperties file: 'gradle.properties'
                    env.projectName = props.projectName
                    env.projectGroup = props.projectGroup
                    env.projectVersion = props.projectVersion
                    env.projectImage = 'feurle/'+env.projectName+':'+env.projectVersion
                }
                echo "Project Name: $projectName"
                echo "Project Group: $projectGroup"
                echo "Project Version: $projectVersion"
                echo "Project Image: $projectImage"
            }
        }
        stage('Build Artefact') {
            steps {
                echo '==> build image ...'
                sh './gradlew clean bootBuildImage'
            }
        }
        stage('Push Image') {
            steps {
                script {
                    echo '==> push image ...'
                    def props = readProperties file: 'gradle.properties'
                    env.PROJECT_NAME = props['projectName']
                    env.PROJECT_VERSION = props['projectVersion']
                    env.PROJECT_IMAGE = 'feurle/'+env.PROJECT_NAME+':'+env.PROJECT_VERSION
                    withCredentials([string(credentialsId: 'DOCKER' ,variable:'SECRET')]) {
                        sh 'docker login -u feurle -p ${SECRET}'
                        sh 'docker push ${PROJECT_IMAGE}'
                    }
                }
            }
        }

        stage('Deploy Artefact') {
            steps {
                script {
                    def deploymentCredentialsId = 'integration-user-test-key'
                    withCredentials([sshUserPrivateKey(credentialsId: 'integration-user-test-key', keyFileVariable: 'KEY_FILE', usernameVariable: 'USERNAME')]) {
                                        def remote = [:]
                                        remote.name = DOMAIN_TEST
                                        remote.host = DEPLOYMENT_HOST_TEST
                                        remote.user = USERNAME
                                        remote.identityFile = KEY_FILE
                                        remote.allowAnyHosts = true
                                        sshScript remote: remote, script: '/appbase/feurle-website/redeploy.sh ${PROJECT_IMAGE}'
                    }
                }
                echo '======================= END OF Jenkinsfile ======================='
            }
        }

    }
}