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
                withSonarQubeEnv() {
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
              input{
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
            

}
