node ('linux'){
  stage 'Build and Test'
  env.PATH = "${tool 'Gradle'}/bin:${env.PATH}"
  checkout scm
  sh 'gradle build'
 }
