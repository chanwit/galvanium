package galvanium.module

import org.zkoss.zkgrails.*

import org.eclipse.jgit.*
import org.eclipse.jgit.revwalk.*
import org.eclipse.jgit.lib.*

class GitComposer extends GrailsComposer {

    def lblRepository
    def gdRevisions

    def afterCompose = { window ->
        def builder = new RepositoryBuilder()
        def repo = builder.setGitDir(new File("/tmp/test-repo/.git")).readEnvironment().findGitDir().build()
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
    }
}
