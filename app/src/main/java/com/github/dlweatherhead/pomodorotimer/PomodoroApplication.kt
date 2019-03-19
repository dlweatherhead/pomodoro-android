package com.github.dlweatherhead.pomodorotimer

import android.app.Application
import com.github.dlweatherhead.pomodorotimer.utility.PomodoroTimerBuilder
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    viewModel { PomodoroTimerViewModel(get()) }
    single { PomodoroTimerBuilder() }
}

class PomodoroApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(
            androidContext = (this@PomodoroApplication),
            modules = listOf(appModule)
        )
    }
}