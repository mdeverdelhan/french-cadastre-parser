package eu.verdelhan.cadastrefr.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TsurfFeatureCollection(@SerialName("type") val type: String,
                                  @SerialName("features") val features : List<TsurfFeature>
)

@Serializable
data class TsurfFeature(@SerialName("geometry") val geometry: TsurfGeometry,
                        @SerialName("id") val id: String,
                        @SerialName("properties") val properties: TsurfProperties,
                        @SerialName("type") val type: String
)

@Serializable
data class TsurfGeometry(@SerialName("coordinates") val coordinates: List<List<List<Double>>>,
                         @SerialName("type") val type: String
)

@Serializable
data class TsurfProperties(@SerialName("SYM") val sym: String,
                           @SerialName("DATE_OBS") val dateObs: String,
                           @SerialName("DATE_MAJ") val dateMaj: String
)