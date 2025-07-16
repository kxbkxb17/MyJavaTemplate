pipeline {
  agent any

  environment {
    IMAGE_NAME = 'my-java-template'
    IMAGE_TAG = 'latest'
    CONTAINER_NAME = 'my-java-template'
  }

  stages {
    stage('拉取代码') {
      steps {
        git url: 'https://github.com/kxbkxb17/MyJavaTemplate.git', branch: 'master'
        echo '拉取代码完成'
      }
    }

    stage('打包Java项目') {
      steps {
        sh 'mvn clean package -Dmaven.test.skip=true'
        echo '打包Java项目完成'
      }
    }

    stage('构建Java镜像') {
      steps {
        sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
        echo '构建Java镜像完成'
      }
    }
    // 本地部署
	stage('重启Java容器') {
      steps {
        script {
          sh """
            docker stop my-java-template || true
            docker rm my-java-template || true
            docker run -itd -u root --name my-java-template -p 40000:40000 -v /var/docker/my-java-template/app:/app my-java-template
          """
          echo '重启Java容器完成'
        }
      }
	}
  }
}