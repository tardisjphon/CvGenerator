package di

import cv.CvFactory
import dagger.Component
import repository.di.DataModule
import repository.local.json.JsonRepository


@Component(
    modules = [DataModule::class, CvFactoryModule::class]
)
interface ApplicationGraph
{
    fun jsonRepository(): JsonRepository
    fun cvFactory(): CvFactory
}