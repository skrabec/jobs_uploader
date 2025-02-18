timeout(5) {
    node('maven') {

        stage('checkout') {
            checkout scm
        }

        stage('Update jobs') {
            sh '''
                cd jenkins
                docker build -t jenkins_updater .
                docker run -v ${WORKSPACE}/jenkins/jobs:/root/jobs_builder/jobs jenkins_updater
            '''
        }

    }
}