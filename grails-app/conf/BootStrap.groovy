class BootStrap {

    def init = { servletContext ->
    	new team18.Student(username:"B5800000",password: "123",email:"b5800000@testing.in.th",status:1,gender:2,name:"คฤจภัค คิศถฤงคิษแคธ",nameEng:"KitchaPik Kittiungkitkat").save()
    	new team18.Student(username:"B5800001",password: "123",email:"b5800001@testing.in.th",status:1,gender:1,name:"สมชาย ใจดี",nameEng:"Somchai Jaidee").save()


    	println("Intalling Test Data")
    }
    def destroy = {
    }
}
