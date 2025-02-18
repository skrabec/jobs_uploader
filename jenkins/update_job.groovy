timeout(5) {
    node('built-in') {

        stage('checkout') {
            checkout scm
        }

        stage('Update jobs') {
            sh "jenkins-jobs --conf ./job.ini update ./jobs"
        }

    }
}