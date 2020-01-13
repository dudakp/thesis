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
//                    sh "docker-compose up"
                sh "docker stop thesis-spring"
                sh "docker rm thesis-spring"
                sh "docker build -t dudak/thesis ."
                sh "docker run -d -p 8081:8081 --name thesis-spring dudak/thesis"
                echo "Dockerizing app complete!"
            }
        }

    }
}
