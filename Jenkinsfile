pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v $HOME.m2:/root/.m2'
            args '-v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    environment {
        CI = 'true'
    }
    stages {
        stage('Build') {
            steps {
                echo 'java springboot3 package'
            }
        }
        stage('Test') {
            steps {
                echo 'java springboot3 test'
            }
        }
        stage('Deliver for development') {
            when {
                branch 'development'
            }
            steps {
                input message: 'Finished using the web site? (Click "Proceed" to continue)'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Deploy for production') {
            when {
                branch 'production'
            }
            steps {
                input message: 'Finished using the web site? (Click "Proceed" to continue)'
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
