package com.valsagnapps.dndapp.config

import com.valsagnapps.dndapp.application.port.outbound.CharacterRepository
import com.valsagnapps.dndapp.application.service.CharacterService
import com.valsagnapps.dndapp.application.service.ClassCatalogService
import com.valsagnapps.dndapp.application.service.CombatService
import com.valsagnapps.dndapp.application.service.ResourceService
import com.valsagnapps.dndapp.application.service.RestService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

// Los servicios de aplicación no conocen Spring: se registran acá como beans.
@Configuration(proxyBeanMethods = false)
class ApplicationConfig {
    @Bean
    fun characterService(characterRepository: CharacterRepository) = CharacterService(characterRepository)

    @Bean
    fun combatService(characterRepository: CharacterRepository) = CombatService(characterRepository)

    @Bean
    fun resourceService(characterRepository: CharacterRepository) = ResourceService(characterRepository)

    @Bean
    fun restService(characterRepository: CharacterRepository) = RestService(characterRepository)

    @Bean
    fun classCatalogService() = ClassCatalogService()
}
