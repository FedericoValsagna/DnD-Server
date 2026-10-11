package com.valsagnapps.dndapp.adapter.inbound.web

import com.valsagnapps.dndapp.application.port.inbound.CreateCharacterUseCase
import com.valsagnapps.dndapp.application.port.inbound.DeleteCharacterUseCase
import com.valsagnapps.dndapp.application.port.inbound.GetCharacterUseCase
import com.valsagnapps.dndapp.application.port.inbound.ListCharactersUseCase
import com.valsagnapps.dndapp.application.port.inbound.UpdateAbilityScoresUseCase
import com.valsagnapps.dndapp.application.port.inbound.UpdateClassesUseCase
import com.valsagnapps.dndapp.application.port.inbound.UpdateHitPointsUseCase
import com.valsagnapps.dndapp.application.port.inbound.UpdateNameUseCase
import com.valsagnapps.dndapp.application.port.inbound.UpdateSkillsUseCase
import com.valsagnapps.dndapp.application.port.inbound.UpdateSubclassUseCase
import com.valsagnapps.dndapp.domain.CharacterClass
import com.valsagnapps.dndapp.domain.CharacterId
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/characters")
class CharacterController(
    private val createCharacter: CreateCharacterUseCase,
    private val getCharacter: GetCharacterUseCase,
    private val listCharacters: ListCharactersUseCase,
    private val updateSkills: UpdateSkillsUseCase,
    private val updateClasses: UpdateClassesUseCase,
    private val updateSubclass: UpdateSubclassUseCase,
    private val updateHitPoints: UpdateHitPointsUseCase,
    private val updateName: UpdateNameUseCase,
    private val updateAbilityScores: UpdateAbilityScoresUseCase,
    private val deleteCharacter: DeleteCharacterUseCase,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@Valid @RequestBody request: CreateCharacterRequest): CharacterResponse =
        CharacterResponse.from(createCharacter.create(request.toCommand()))

    @GetMapping
    fun list(): List<CharacterResponse> = listCharacters.list().map(CharacterResponse::from)

    @GetMapping("/{id}")
    fun get(@PathVariable id: UUID): CharacterResponse = CharacterResponse.from(getCharacter.get(CharacterId(id)))

    @PutMapping("/{id}/skills")
    fun updateSkills(@PathVariable id: UUID, @RequestBody request: UpdateSkillsRequest): CharacterResponse =
        CharacterResponse.from(updateSkills.updateSkills(CharacterId(id), request.toDomain()))

    @PutMapping("/{id}/classes")
    fun updateClasses(@PathVariable id: UUID, @Valid @RequestBody request: UpdateClassesRequest): CharacterResponse =
        CharacterResponse.from(updateClasses.updateClasses(CharacterId(id), request.toDomain()))

    @PutMapping("/{id}/classes/{characterClass}/subclass")
    fun updateSubclass(
        @PathVariable id: UUID,
        @PathVariable characterClass: CharacterClass,
        @RequestBody request: UpdateSubclassRequest,
    ): CharacterResponse =
        CharacterResponse.from(updateSubclass.updateSubclass(CharacterId(id), characterClass, request.subclass))

    @PutMapping("/{id}/hit-points")
    fun updateHitPoints(
        @PathVariable id: UUID,
        @Valid @RequestBody request: UpdateHitPointsRequest,
    ): CharacterResponse =
        CharacterResponse.from(updateHitPoints.updateMaxHitPoints(CharacterId(id), request.maxHitPoints))

    @PutMapping("/{id}/name")
    fun updateName(@PathVariable id: UUID, @Valid @RequestBody request: UpdateNameRequest): CharacterResponse =
        CharacterResponse.from(updateName.updateName(CharacterId(id), request.name))

    @PutMapping("/{id}/ability-scores")
    fun updateAbilityScores(
        @PathVariable id: UUID,
        @Valid @RequestBody request: UpdateAbilityScoresRequest,
    ): CharacterResponse = CharacterResponse.from(
        updateAbilityScores.updateAbilityScores(CharacterId(id), request.abilityScores.toDomain()),
    )

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) = deleteCharacter.delete(CharacterId(id))
}
