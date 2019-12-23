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
            try {
                sh "docker stop dudak/thesis"
            } catch (e) {
                sh "container not found"
            }
                sh "docker build -t dudak/thesis ."
                sh "docker run -p 8081:8081 -p 32768:32768 dudak/thesis"
                echo "Dockerizing app complete!"
            }
        }

    }
}
