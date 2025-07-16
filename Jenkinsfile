pipeline {
  agent any

  environment {
    IMAGE_NAME = 'my-java-template'
    IMAGE_TAG = 'latest'
  }

  stages {
    stage('拉取代码') {
      steps {
        git url: 'https://github.com/kxbkxb17/MyJavaTemplate.git', branch: 'master'
      }
    }

    stage('构建 Java 项目') {
      steps {
        sh 'mvn clean package -Dmaven.test.skip=true'
      }
    }

    stage('构建 Docker 镜像') {
      steps {
        sh 'docker build -t $IMAGE_NAME:$IMAGE_TAG .'
      }
    }
    // 本地部署
	stage('重启容器') {
		steps {
			script {
				sh """
					docker stop ${CONTAINER_NAME} || true
					docker rm ${CONTAINER_NAME} || true
					docker run -itd -u root --name ${CONTAINER_NAME} -p 40000:40000 -v /var/docker/my-java-template/app:/app ${IMAGE_NAME}
				"""
			}
		}
	}
}