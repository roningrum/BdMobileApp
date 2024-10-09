pipeline {
    agent any

    stages {
        stage('Clone repository') {
            steps {
                git branch: 'main', url: 'https://github.com/roningrum/BdMobileApp.git'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }

        stage('Run Tests') {
            steps {
                sh './gradlew test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withCredentials([string(credentialsId: 'sonar-token', variable: 'SONARQUBE_TOKEN')]) {
                    withSonarQubeEnv('SonarQube Server') {
                        sh './gradlew sonarqube -Dsonar.projectKey=your-project-key -Dsonar.host.url=http://localhost:9000 -Dsonar.login=$SONARQUBE_TOKEN'
                    }
                }
            }
        }

        stage('Quality Gate') {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: '**/build/libs/*.jar', allowEmptyArchive: true
            junit '**/build/test-results/test/*.xml'
        }
        failure {
            echo 'Pipeline failed!'
        }
    }
}
