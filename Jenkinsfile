node {
  stage 'Build '
  env.PATH = "${tool 'Gradle'}/bin:${env.PATH}"
  checkout scm
  sh 'gradle build'

  stage 'Test'
  sh 'gradle test'
 }
