pipeline {
    agent {label "mysshnode"}

    tools {
        gradle "mygradle"
        jdk "java8"
    }
    
    stages {
        stage('gradleCompile') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/erasgupta/springbootdemo.git'

                // Run Maven on a Unix agent.
                sh "gradle clean assemble"
            }
        }
    stage('Build Docker Image') {
            steps {
                script {
                    app = docker.build('erashish01/myspringbootapp')
                }
            }
        }
        stage('Push Docker Image') {
            steps {
                script {
                    withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
                        app.push("${env.BUILD_NUMBER}")
                        app.push("latest")
                    }
                }
            }
        }
        
        stage('Deploy') {
            steps {
                sh 'docker run -dt -p 8081:8081 --name myspringbootapp erashish01/myspringbootapp'
            }
        }    
    }
}

