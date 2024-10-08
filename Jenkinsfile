pipeline {
    agent any

    environment {
        ANDROID_HOME = 'C:/Users/oktav/AppData/Local/Android/Sdk'  // Ganti dengan path SDK Android yang benar
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/roningrum/BdMobileApp.git', credentialsId: 'github-token'
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x ./gradlew'
                sh './gradlew assembleDebug'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh 'sonar-scanner'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying APK...'
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
