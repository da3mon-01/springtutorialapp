node {
  stage('Build'){
    env.PATH = "${tool 'Gradle'}/bin:${env.PATH}"
    checkout scm
    sh 'gradle clean build -x test'
  }
  stage('Test'){
    sh 'gradle test'
  }
  stage('Archiving Artifacts'){
   archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
  }
  docker.withServer('10.0.2.15:2375/'){
    stage('Build Docker Image'){
     env.PATH = "${tool 'docker'}/bin:${env:PATH}"
     def tutorialapp = docker.build("da3mon/tutorialapp:${env.BUILD_TAG}")
    }
  }
 }
