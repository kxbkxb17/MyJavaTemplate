pipeline {
  agent any
  stages {
    stage('拉取代码') {
      steps {
        git(url: 'https://github.com/kxbkxb17/MyJavaTemplate.git', branch: 'master')
        echo 'git pull successed.'
      }
    }

  }
  environment {
    IMAGE_NAME = 'my-java-template'
    IMAGE_TAG = 'latest'
    CONTAINER_NAME = 'my-java-template'
  }
}