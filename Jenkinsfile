pipeline {
  options {
    ansiColor('xterm')
  }
  agent any
  stages {
    stage('Build') {
      steps {
        echo '==> build ...'
        sh './gradlew clean build'
        echo '==> build image ...'
        sh './gradlew bootBuildImage'
      }
    }
  }
}