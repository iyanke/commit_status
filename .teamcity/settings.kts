import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2021.1"

project {

    buildType(GitHub)
}

object GitHub : BuildType({
    name = "GitHub"

    vcs {
        root(AbsoluteId("PullRequestsPlugin_HttpsGithubComIyankeTests"))
    }

    triggers {
        vcs {
        }
    }

    features {
        commitStatusPublisher {
            vcsRootExtId = "PullRequestsPlugin_HttpsGithubComIyankeTests"
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "6acd9e1c8643257660ba57e4b1977218208928103a2f279d21d99260bb6341d9cfd576c41f4874efaacc581f73a65f760cb8cb953ecc8eb1b4d9c2248840fecea687753c15109fee772d2a9bfa2fbeb38901383bc32d7fbc27c8b54f3b6775d03cbe80d301b"
                }
            }
            param("github_oauth_user", "iyanke")
        }
    }
})
