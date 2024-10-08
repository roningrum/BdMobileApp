pipeline {
    agent any

    environment {
        SONAR_SCANNER_HOME = tool name: 'SonarQubeScanner', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/roningrum/BdMobileApp.git', credentialsId: 'github-token'
            }
        }

        stage('Build') {
            steps {
                sh './gradlew assembleDebug'  // Build APK
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'  // Run unit tests
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh "${SONAR_SCANNER_HOME}/bin/sonar-scanner"
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying APK...'  // Jika ada deployment step
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded'
        }
        failure {
            echo 'Pipeline failed'
        }
    }
}
