package eu.verdelhan.cadastrefr.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the properties of an address, typically returned by the BAN (Base Adresse Nationale).
 */
@Serializable
data class AdresseProperties(
    @SerialName("label") val label: String,
    @SerialName("score") val score: Double,
    @SerialName("housenumber") val housenumber: String? = null,
    @SerialName("id") val id: String,
    @SerialName("banId") val banId: String? = null,
    @SerialName("name") val name: String,
    @SerialName("postcode") val postcode: String,
    @SerialName("citycode") val citycode: String,
    @SerialName("x") val x: Double,
    @SerialName("y") val y: Double,
    @SerialName("city") val city: String,
    @SerialName("context") val context: String,
    @SerialName("type") val type: String,
    @SerialName("importance") val importance: Double,
    @SerialName("street") val street: String,
    @SerialName("distance") val distance: Int,
    @SerialName("_type") val underscoreType: String
)
