pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'Jenkins SSH key', url: 'git@github.com:roningrum/BdMobileApp.git'
            }
        }
        stage('Build') {
            steps {
                // Build steps here
                echo 'Building...'
            }
        }
    }
}
