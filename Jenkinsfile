node {
  stage('Build'){
    env.PATH = "${tool 'Gradle'}/bin:${env.PATH}"
    checkout scm
    sh 'gradle build -x test'
  }
  stage('Test'){
    sh 'gradle test'
  }
  stage('Archiving Artifacts'){
   archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
  }
  stage('Build Docker Image'){
    docker.withServer('10.0.2.15:2375'){
     def tutorialapp = docker.build "da3mon/tutorialapp:${env.BUILD_TAG}" 
    }
  }
 }
