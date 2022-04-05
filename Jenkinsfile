pipeline {
    //Donde se va a ejecutar el Pipeline
    agent {
        label 'Slave_Induccion'
    }
    //Opciones específicas de Pipeline dentro del Pipeline
    options {
        buildDiscarder(logRotator(numToKeepStr: '3'))
         disableConcurrentBuilds()
    }

    //Una sección que define las herramientas “preinstaladas” en Jenkins
    tools {
        jdk 'JDK11_Centos' //Verisión preinstalada en la Configuración del Master
    }

    //Aquí comienzan los “items” del Pipeline
    stages{

        stage('Checkout') {
            steps{
            echo "------------>Checkout<------------"
            checkout([
                $class: 'GitSCM',
                branches: [[name: '*/master']],
                doGenerateSubmoduleConfigurations: false,
                extensions: [],
                gitTool: 'Default',
                submoduleCfg: [],
                userRemoteConfigs: [[
                credentialsId: 'GitHub_JairoIbarra',
                url:'https://github.com/Jairo10Ibarra/adnBackend.git'
                ]]
            ])

            }
        }

        stage('Clean') {
              steps{
                sh 'chmod +x ./microservicio/gradlew'
                echo "------------>Clean<------------"
                sh './microservicio/gradlew --b ./microservicio/build.gradle clean' //Asegurar no tener datos basura de compilaciones anteriores
              }
            }

            stage('Unit Tests') {
              steps{
                sh 'chmod +x ./microservicio/gradlew'
                echo "------------>Unit Tests<------------"
                sh './microservicio/gradlew --b ./microservicio/build.gradle test'
              }
            }


            stage('Static Code Analysis') {
              steps{
                echo '------------>Análisis de código estático<------------'
                withSonarQubeEnv('Sonar') {
                    sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner -Dproject.settings=sonar-project.properties"
                }
              }
            }

              stage('Build') {
              steps{
                sh 'chmod +x ./microservicio/gradlew'
                echo "------------>Build<------------"
                sh './microservicio/gradlew --b ./microservicio/build.gradle build -x test'
              }
            }

          }

          post {
            always {
              echo 'This will always run'
            }
            success {
              echo 'This will run only if successful'
              //junit '**/test-reports/*.xml' //RUTA DE TUS ARCHIVOS .XML
            }
            failure {
              echo 'This will run only if failed'
              //mail (to: 'leonardo.cruz@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
            }
            unstable {
              echo 'This will run only if the run was marked as unstable'
            }
            changed {
              echo 'This will run only if the state of the Pipeline has changed'
              echo 'For example, if the Pipeline was previously failing but is now successful'
            }

          }
}