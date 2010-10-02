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
        new Setting(key:"module.scm.git.repository", value:"/tmp/test-repo/.git").save()
    }

    def destroy = {
    }
}
