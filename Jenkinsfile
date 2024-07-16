pipeline {
    agent any 
    stages {
        stage('Compile and Clean') { 
            steps {

                sh "mvn clean compile"
            }
        }
        stage('Test') { 
            steps {
                sh "mvn test site"
            }
            
             post {
                always {
                    junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'   
                }
            }     
        }

        stage('deploy') { 
            steps {
                sh "mvn package"
            }
        }

        stage('SonarQube analysis'){
             steps{
                withSonarQubeEnv('Sonarqube')
                  sh "mvn sonar:sonar \
                      -Dsonar.projectKey=demo \
                      -Dsonar.host.url=http://localhost:9000 \
                      -Dsonar.login=c342f1102f7aad0b382d136f194caf660352d799"
             }
        
        }
        stage("Quality Gate") {
            steps {
               timeout(time: 1, unit: 'MINUTES') {
                   waitForQualityGate abortPipeline: true
    }
  }
}
      
        }
    }


