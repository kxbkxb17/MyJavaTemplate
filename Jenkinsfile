pipeline {
  agent any
  tools {
      jdk 'jdk21'
      maven 'maven3'
  }

  stages {
    stage('拉取代码') {
      steps {
        git(url: 'https://github.com/kxbkxb17/MyJavaTemplate.git', branch: 'master')
        echo 'git pull success.'
      }
    }
    stage('打包Java项目') {
          steps {
            sh 'java -version'
            sh 'mvn clean package -Dmaven.test.skip=true'
            echo 'mvn package success.'
          }
        }

  }
  environment {
    IMAGE_NAME = 'my-java-template'
    IMAGE_TAG = 'latest'
    CONTAINER_NAME = 'my-java-template'
  }
}