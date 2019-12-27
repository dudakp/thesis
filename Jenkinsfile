pipeline {
    agent any

    tools {
        maven "Maven 3.6.0"
    }

    stages {

        stage('Build'){
        steps {
            sh "mvn clean install"
            sh "whoami"
            }
        }

        stage('Docker build and run') {
            steps {
                sh "docker build -t dudak/thesis ."
                sh "docker run -p 8081:8081 -p 32768:30000 dudak/thesis"
                echo "Dockerizing app complete!"
            }
        }

    }
}
