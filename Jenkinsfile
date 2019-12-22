pipeline {
    agent any

    stages {

        stage('Build'){
        steps {
            sh "mvn clean install"
            }
        }

        stage('Docker build and run') {
            steps {
                sh "docker build -t dudak/thesis ."
                sh "docker run -p 8081:8081 dudak/thesis"
                echo "Dockerizing app complete!"
            }
        }

    }
}

