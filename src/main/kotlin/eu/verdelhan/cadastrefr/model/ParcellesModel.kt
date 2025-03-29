package eu.verdelhan.cadastrefr.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ParcelleFeatureCollection(@SerialName("type") val type: String,
                                     @SerialName("features") val features : List<ParcelleFeature>
)

@Serializable
data class ParcelleFeature(@SerialName("geometry") val geometry: ParcelleGeometry,
                           @SerialName("id") val id: String,
                           @SerialName("properties") val properties: ParcelleProperties,
                           @SerialName("type") val type: String
)

@Serializable
data class ParcelleGeometry(@SerialName("coordinates") val coordinates: List<List<List<Double>>>,
                            @SerialName("type") val type: String
)

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