pipeline {
    agent any

    stages {
        stage('Checkout & Run Tests') {
            steps {
                git branch: 'feature/login', url: 'https://github.com/aswathy-anupam/Selenium-TestNG-Framework.git'
                bat 'mvn test'
            }
        }
    }
}