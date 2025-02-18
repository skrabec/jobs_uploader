timeout(5) {
    node("maven-slave") {
        stage("Checkout") {
            checkout scm
        }
        
        stage("Install jenkins-jobs") {
            sh '''
                apt-get update
                apt-get install -y python3-pip
                pip3 install jenkins-job-builder==6.4.2
            '''
        }
        
        stage("Deploy changes to jenkins") {
            dir("jenkins") {
                sh "jenkins-jobs --conf ./jobs/jobs.ini update ./jobs"
            }
        }
    }
}