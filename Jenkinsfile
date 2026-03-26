pipeline {
    agent any
    tools {
        jdk 'Java21' // This matches the Name you just gave it in Jenkins Tools
    }
    stages {
        stage('Build Artifact') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Docker Image') {
            steps {
                // Building the image with a specific tag
                sh 'docker build -t vippul36/practice:latest .'
            }
        }
        stage('Run Container') {
            steps {
                sh 'docker stop practice-app || true'
                sh 'docker rm practice-app || true'
                sh 'docker run -d -p 80:8085 --name practice-app vippul36/practice:latest'
            }
        }
    }
}
