package eu.krzdabrowski.currencyadder.core.common.entities.di

import javax.inject.Qualifier

@Retention
@Qualifier
annotation class MainImmediateScope // UI-related

@Retention
@Qualifier
annotation class IoScope // I/O-related

@Retention
@Qualifier
annotation class DefaultScope // CPU-related