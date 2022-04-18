pipeline{
    agent any
    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage ('Checkout Source') {
            steps {
                checkout scm
            }
        }
        stage ('Docker Build and Push') {
            steps {
                sh 'docker version'
                sh 'git config --global user.email "thujithaponnuthurai@gmail.com"'
                sh 'git config --global user.name "Thuji98"'
                withCredentials([gitUsernamePassword(credentialsId: 'GIT_HUB_CREDENTIALS', gitToolName: 'git-tool')]) {
                  sh 'mvn release:prepare -Dresume=false'
                  sh 'mvn dockerfile:push'
                }
            }
        }
        stage ('Kubernetes Deployment') {
            steps {
                 withKubeConfig([credentialsId: 'kubeconfig1']) {
                      sh 'kubectl apply -f deployment.yml'
                 }
            }
        }
    }
}