package galvanium.module

import org.zkoss.zkgrails.*

import galvanium.*

import org.eclipse.jgit.*
import org.eclipse.jgit.revwalk.*
import org.eclipse.jgit.lib.*

class GitComposer extends GrailsComposer {

    def lblRepository
    def tree
    def gdRevisions

    def afterCompose = { window ->
        def builder = new RepositoryBuilder()
        // TODO read from config
        def gitRepository = Setting.findByKey("module.scm.git.repository")
        if(gitRepository) {
            def repo = builder.setGitDir(new File(gitRepository.value)).readEnvironment().findGitDir().build()
            lblRepository.value = "Git repository - ${repo.getBranch()}"
            def walk = new RevWalk(repo)
            def headCommit = walk.parseCommit(repo.resolve("HEAD"))
            walk.markStart(headCommit)
            // TODO: just only 10 revisions to display
            walk.each { commit ->
                gdRevisions.rows.append {
                    row {
                        label(value: commit.name[0..9])
                        label(value: commit.authorIdent.when)
                        label(value: commit.authorIdent.name)
                        label(value: commit.shortMessage)
                        // todo: possibly adding link with h.html(value: "...")
                    }
                }
            }
            repo.close()
        } else {
            lblRepository.value = "Required setting Git repository."
            tree.visible = false
            gdRevisions.visible = false
        }
    }
}
