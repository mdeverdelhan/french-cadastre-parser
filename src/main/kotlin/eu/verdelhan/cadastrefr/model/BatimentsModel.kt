package eu.verdelhan.cadastrefr.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BatimentFeatureCollection(@SerialName("type") val type: String,
                                     @SerialName("features") val features : List<BatimentFeature>
)

@Serializable
data class BatimentFeature(@SerialName("geometry") val geometry: BatimentGeometry,
                           @SerialName("properties") val properties: BatimentProperties,
                           @SerialName("type") val type: String
)

@Serializable
data class BatimentGeometry(@SerialName("coordinates") val coordinates: List<List<List<List<Double>>>>,
                            @SerialName("type") val type: String
)

@Serializable
data class BatimentProperties(@SerialName("type") val type: String,
                              @SerialName("nom") val nom: String? = null,
                              @SerialName("commune") val commune: String,
                              @SerialName("created") val created: String,
                              @SerialName("updated") val updated: String
)