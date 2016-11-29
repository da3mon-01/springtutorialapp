node {
  //def dockerHome = tool name: 'docker', type: 'org.jenkinsci.plugins.docker.commons.tools.DockerTool'
  def gradleHome = tool name: 'Gradle', type: 'hudson.plugins.gradle.GradleInstallation'
  env.PATH = "${gradleHome}/bin:${env.PATH}"
  stage('Build'){
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
     def tutorialapp = docker.build("da3mon/tutorialapp:${env.BUILD_TAG}")
    }
  }
 }
