import galvanium.*

class BootStrap {

    def init = { servletContext ->

        //
        // Setting up some modules
        //
        new Module(name:"Overview").save()
        new Module(name:"Download", enabled:"false").save()
        new Module(name:"Activity").save()
        new Module(name:"Roadmap").save()
        new Module(name:"Issues").save()
        new Module(name:"News", enabled:"false").save()
        new Module(name:"Wiki", enabled:"false").save()
        new Module(name:"Forums", enabled:"false").save()
        new Module(name:"Repository", url:"module/git.zul").save()

        //
        // Setting up some configs
        //
        new Setting(key:"module.scm.git.repository", 
                    value:"/tmp/test-repo/.git",
                    enabled:false).save()

        // Setting up some projects
        new Project(name:"Galvanium", 
                    shortName:"galvanium", 
                    description:"This is the galvanium project.").save()
        new Project(name:"Redmine", 
                    shortName:"redmine", 
                    description:"Redmine is a flexible project management web application written using Ruby on Rails framework.").save()
    }

    def destroy = {
    }
}
