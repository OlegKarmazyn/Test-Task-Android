package solid.icon.testtask

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import solid.icon.testtask.data.database.AppDatabase
import solid.icon.testtask.data.repository.BaseModel
import solid.icon.testtask.data.repository.MainViewModel

class App : Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@App))

        bind<AppDatabase>() with singleton { AppDatabase(instance()) }
        bind<BaseModel>() with singleton { BaseModel(instance()) }
        bind<MainViewModel>() with singleton { MainViewModel(instance()) }
    }
}
