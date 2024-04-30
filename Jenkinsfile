pipeline {

      tools {
        // a bit ugly because there is no `@Symbol` annotation for the DockerTool
        // see the discussion about this in PR 77 and PR 52:
        // https://github.com/jenkinsci/docker-commons-plugin/pull/77#discussion_r280910822
        // https://github.com/jenkinsci/docker-commons-plugin/pull/52
        'org.jenkinsci.plugins.docker.commons.tools.DockerTool' '18.09'
      }
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v $HOME.m2:/root/.m2'
//             args '-v /var/run/docker.sock:/var/run/docker.sock'
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
