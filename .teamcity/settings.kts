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
            enabled = false
        }
    }

    features {
        commitStatusPublisher {
            vcsRootExtId = "PullRequestsPlugin_HttpsGithubComIyankeTests"
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "zxx11e0e665cfb44d64f3ff076157556d86c7ba92b60cdc61b254468912eb637cd7c9d8c362c1f1238924362e60b79fb5b8a888a9cf260c810cc6cdf052bd3a5ac5f59bdd89138807a7f0f10f9095b30b6db200baba8fa08336"
                }
            }
        }
    }
})
