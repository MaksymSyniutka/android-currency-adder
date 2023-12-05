package com.exampleeu.krzdabrowski.currencyadder.core.base.kotlin

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