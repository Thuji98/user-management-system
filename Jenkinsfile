pipeline{
    agent any
    stages {
        stage ('Checkout Source') {
            steps {
                checkout scm
            }
        }


        stage ('Initialize release prepare, perform') {
            sh 'mvn initialize release:clean release:prepare release:perform'
        }
        stage ('Kubernetes Deployment') {
            steps {
                 withKubeConfig([credentialsId: 'kubeconfig1']) {
                      sh 'kubectl apply -f deployment.yml'
                      sh 'kubectl rollout restart deployment user-management -n default'
                 }
            }
        }
    }
}