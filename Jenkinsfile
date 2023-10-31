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

        stage("sonarqube") {
            agent any
            steps {
                def mvn = tool 'maven';
                withSonarQubeEnv("sonarqube") {
                    sh "${mvn}/bin/mvn clean verify sonar:sonar -Dsonar.projectKey=gcp-demo-project"
                }
            }
        }

        stage("Quality gate") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }//Quality gate


        stage('Approve Deployment') {
            agent any
            input {
                message "Do you want to proceed for deployment?"
            }
            steps {
                //Add deploy steps & Alerts below
                sh 'echo "Deploying into Server"'

            }
        } // Approve Deployment

    } // stages

    post {

        aborted {
            echo "Sending message to Slack for aborted"
        } // aborted

        failure {

            echo "Sending message to Slack for failure"
        } // failure

        success {
            echo "Sending message to Slack for success"
        } // success

    } // post


    node(label:'main') {

        stage('Static Analysis') {
            withSonarQubeEnv('sonarqube') {
                bat 'mvn clean package sonar:sonar'
                echo 'Static Analysis Completed'
            }
            stage("Quality Gate") {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                    def qg= waitForQualityGate()
                    if (qg.status!= 'OK') {
                        error "Pipeline aborted due to quality gate failure: ${qg.status}"
                    }
                }
                echo 'Quality Gate Passed'
            }
        }

    }
}
