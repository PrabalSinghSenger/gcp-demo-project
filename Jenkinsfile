pipeline {
    agent any
    
    tools {
        maven 'maven'
    }

    stages {
        stage ('Initialize') {
            steps {
                sh 'echo "PATH = ${PATH}"'
                sh 'echo "M2_HOME = ${M2_HOME}"'
            }
        }
        stage ('Build') {
            steps {
                sh 'mvn clean package'
            }
            post {
                    success {
                        junit 'target/surefire-reports/**/*.xml'
                 }
            }
        }

         stage("Quality gate") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }
    
    
        node {
          stage('SCM') {
            checkout scm
          }
          stage('sonarqube') {
                def mvn = tool 'maven';
                withSonarQubeEnv() {
                  sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=gcp-demo-project"
                }
          }
        }
}
}
