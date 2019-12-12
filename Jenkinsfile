#!groovy
/**
 * Jenkinsfile to build AutoQ and run test modules
 * Deploys new snapshot to Nexus if all tests succeed
 */
def testCommand = 'mvn -PautoqTest -Dmaven.test.failure.ignore clean test'
def cukesCommand = 'mvn -PautoqTest -Dmaven.test.failure.ignore -DuseCucumber clean test'
def cleanCommand = 'mvn clean'
def statsCommand = 'mvn -Dcheckstyle.config.location="google_checks.xml" checkstyle:checkstyle javadoc:javadoc sonar:sonar'
def archiveCommand = 'mvn assembly:single'
properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '50')), disableConcurrentBuilds(), pipelineTriggers([])])
node() {
    stage('Checkout') {
        checkout scm
    }

    stage('Test') {
        withMaven(
                maven: 'm350',
                mavenLocalRepo: '.repository',
                mavenSettingsConfig: 'autoQtestrunner'
        ) {
            if (isUnix()) {
                sh testCommand
                sh cukesCommand
            } else {
                bat testCommand
                bat cukesCommand
            }
            //junit 'target/**/TEST*.xml'
        }
    }

    if (currentBuild.result == null) {
        stage('Archive') {
            withMaven(
                    maven: 'm350',
                    mavenLocalRepo: '.repository',
                    mavenSettingsConfig: 'autoQtestrunner',
                    options: [openTasksPublisher(disabled: true)]
            ) {
                if (isUnix()) {
                    sh archiveCommand
                } else {
                    bat archiveCommand
                }
            }
            archiveArtifacts artifacts: 'target/*.zip, target/*.tar.bz2, target/*.tar.gz', excludes: '*.log'
        }

        if (BRANCH_NAME == 'dev' || BRANCH_NAME == 'master') {
            stage('Stats') {
                withMaven(
                        maven: 'm350',
                        mavenLocalRepo: '.repository',
                        mavenSettingsConfig: 'autoQtestrunner',
                        options: [openTasksPublisher(disabled: true)]
                ) {
                    withSonarQubeEnv('qipDemoSonar') {
                        if (isUnix()) {
                            sh statsCommand
                        } else {
                            bat statsCommand
                        }
                    }

                    echo 'Publishing checkstyle results'
                    step([$class: 'CheckStylePublisher', canComputeNew: false, defaultEncoding: '', healthy: '', pattern: '', shouldDetectModules: true, unHealthy: ''])

                    echo 'Publishing Javadoc'
                    step([$class: 'JavadocArchiver', javadocDir: 'target/site/apidocs', keepAll: true])
                }
            }
        }
    }
}