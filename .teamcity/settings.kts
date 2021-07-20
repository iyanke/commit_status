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
                    token = "zxx015b2896a4db1bed3ebdb3849fb614c690a3b1227ac2d34887652a6b811e4e91e1ca93bd356379d5e86350371213b3e51af0c20fbfee0cfdceff1057a34a7c6da09af4d722f30fa7bde581144378df523c47a2418c16a38dfad9edae8c3f928902e7f2ec7bc759bf1fe63e4e1a80bd52825a78b3dbf6971cbd5dcd41112143028f1198e7d0657406abf3541a077d2e2f80e6c1e3a0833f48d52e8d208bfde50a72dd05fa5629647db1667c534cfc5d46ace028a231c76145e4ad66a5b7cd46ee649e4a6fba7e05db19c83ff75279353f"
                }
            }
            param("github_oauth_user", "iyanke")
        }
    }
})
