timeout(5, timeUnit='MINUTES') {
    node('main') {

        stage('checkout') {
            checkout scm
        }

        stage('Update jobs') {
            sh "docker run -t localhost:5005/jenkins_updater https://localhost/jenkins admin admin"
        }

    }
}