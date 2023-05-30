import di.AppDagger
import di.AppKoin
import repository.model.pdf.general.User

class App
{
    init
    {
        val user = User.KIRK

        println("\nCV ${user.name} in progress...")

        //AppDagger(user)
        AppKoin(user)
    }
}