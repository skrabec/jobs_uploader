timeout(5) {
    node("maven") {
        stage("Checkout") {
            checkout scm
        }
        
        stage("Install jenkins-jobs") {
            sh '''
                apt-get update
                apt-get install -y python3-venv
                python3 -m venv /opt/jenkins_jobs_venv
                /opt/jenkins_jobs_venv/bin/pip install jenkins-job-builder==6.4.2
            '''
        }
        
        stage("Deploy changes to jenkins") {
            dir("jenkins") {
                sh "/opt/jenkins_jobs_venv/bin/jenkins-jobs --conf ./jobs.ini update ./jobs"
            }
        }
    }
}