node {
  stage 'Build' {
    env.PATH = "${tool 'Gradle'}/bin:${env.PATH}"
    checkout scm
    sh 'gradle build -x test'
  }
  stage 'Test' {
    sh 'gradle test'
  }
 }
