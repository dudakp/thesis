pipeline {
    agent any

    tools {
        maven "Maven 3.6.0"
    }

    stages {

        stage('Build'){
        steps {
            sh "mvn clean install"
            }
        }

        stage('Docker build and run') {
            docker.build("dudak/thesis", "./Dockerfile")
            steps {
                sh "docker build -t dudak/thesis ."
                sh "docker run -p 8081:8081 dudak/thesis"
                echo "Dockerizing app complete!"
            }
        }

    }
}

