timeout(5) {
    node('python') {

        stage('checkout') {
            checkout scm
        }

        stage('Update jobs') {
            sh "jenkins-jobs --conf ./job.ini update ./jobs"
        }

    }
}