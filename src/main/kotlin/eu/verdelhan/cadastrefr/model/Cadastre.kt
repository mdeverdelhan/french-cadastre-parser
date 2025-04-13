package eu.verdelhan.cadastrefr.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class ParcelleProperties(@SerialName("arpente") val arpente: Boolean,
                              @SerialName("commune") val commune: String,
                              @SerialName("contenance") val contenance: Int,
                              @SerialName("created") val created: String,
                              @SerialName("id") val id: String,
                              @SerialName("numero") val numero: String,
                              @SerialName("prefixe") val prefixe: String,
                              @SerialName("section") val section: String,
                              @SerialName("updated") val updated: String
)

@Serializable
data class BatimentProperties(@SerialName("type") val type: String,
                              @SerialName("nom") val nom: String? = null,
                              @SerialName("commune") val commune: String,
                              @SerialName("created") val created: String,
                              @SerialName("updated") val updated: String
)

@Serializable
data class TsurfProperties(@SerialName("SYM") val sym: String,
                           @SerialName("DATE_OBS") val dateObs: String,
                           @SerialName("DATE_MAJ") val dateMaj: String
)