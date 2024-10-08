pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/roningrum/BdMobileApp.git', credentialsId: 'github-token'
            }
        }

        stage('Build') {
            steps {
                // Berikan izin eksekusi pada file gradlew
                sh 'chmod +x ./gradlew'
                // Jalankan proses build
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
                    sh 'sonar-scanner'  // Run SonarQube analysis
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
