pipeline {
    agent any
    tools { jdk 'Java21' }
    environment {
        DOCKER_IMAGE = "vippul36/practice"
        DOCKER_CREDS = "docker-hub-creds"
    }
    stages {
        stage('Build Artifact') {
            steps { sh 'mvn clean package -DskipTests' }
        }
        stage('Build & Push to Docker Hub') {
            steps {
                script {
                    sh "docker build -t ${DOCKER_IMAGE}:latest ."
                    // This part uses the credentials you just created
                    withCredentials([usernamePassword(credentialsId: "${DOCKER_CREDS}", passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push ${DOCKER_IMAGE}:latest"
                    }
                }
            }
        }
        stage('Run Container') {
            steps {
                sh 'docker stop practice-app || true'
                sh 'docker rm practice-app || true'
                sh "docker run -d -p 80:8085 --name practice-app ${DOCKER_IMAGE}:latest"
            }
        }
    }
}
