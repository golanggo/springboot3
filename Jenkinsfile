pipeline {
    agent any
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
                branch 'dev'
            }
            steps {
                input message: 'Finished using the web site? (Click "Proceed" to continue)'
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Deploy for production') {
            when {
                branch 'pro'
            }
            steps {
                input message: 'Finished using the web site? (Click "Proceed" to continue)'
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}
