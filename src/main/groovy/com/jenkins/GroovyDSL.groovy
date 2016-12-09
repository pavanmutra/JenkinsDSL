job('Booking Service Master Build and Test') {
    scm {
        git {
            remote {
                url 'https://github.com/kakadeajinkya05/reservation.git'
            }
            extensions {
                wipeOutWorkspace()
            }
            branch '*/master'
        }
    }

    steps {
        gradle {
            tasks('clean')
            tasks('test')
            switches('-i')
            useWrapper()
        }
    }

    triggers {
        scm('* * * * *') {
            ignorePostCommitHooks()
        }
    }


    wrappers {
        colorizeOutput()
    }
}