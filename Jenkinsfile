pipeline {
    agent master

    stages {

        stage('Build'){
            sh "mvn clean install"
        }

        stage('Docker build and run') {
            dockerize()
        }

    }
}

def dockerize(){
    sh "docker build -t dudak/thesis ."
    sh "docker run -p 8081:8081 dudak/thesis"
    echo "Dockerizing app complete!"
}

