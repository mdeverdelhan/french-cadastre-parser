package eu.verdelhan.cadastrefr.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonClassDiscriminator

/**
 * Represents a GeoJSON FeatureCollection containing multiple features.
 * @param T the type of the feature's properties
 * @property type the GeoJSON type (always "FeatureCollection")
 * @property features the list of geographic features
 */
@Serializable
data class FeatureCollection<T>(
    val type: String = "FeatureCollection",
    val features: List<Feature<T>>
)

/**
 * Represents a single GeoJSON Feature with geometry and properties.
 * @param T the type of the feature's properties
 * @property type the GeoJSON type (always "Feature")
 * @property id optional unique identifier for the feature
 * @property geometry the geometry of the feature (Point, Polygon, etc.)
 * @property properties the associated properties for the feature
 */
@Serializable
data class Feature<T>(
    val type: String = "Feature",
    val id: String? = null,
    val geometry: Geometry,
    val properties: T
) {
    /**
     * Serializes the geometry of the feature into a JSON string.
     * @return the geometry as a JSON string
     */
    fun getGeometryAsJson(): String {
        return Json.encodeToString(Geometry.serializer(), geometry)
    }
}

/**
 * Base interface for all GeoJSON geometry types.
 */
@Serializable
@OptIn(ExperimentalSerializationApi::class)
@JsonClassDiscriminator("type")
sealed interface Geometry

/**
 * A GeoJSON Point geometry.
 * @property coordinates the coordinates of the point [longitude, latitude]
 */
@Serializable
@SerialName("Point")
data class Point(val coordinates: List<Double>) : Geometry

/**
 * A GeoJSON MultiPoint geometry.
 * @property coordinates a list of point coordinates
 */
@Serializable
@SerialName("MultiPoint")
data class MultiPoint(val coordinates: List<List<Double>>) : Geometry

/**
 * A GeoJSON LineString geometry.
 * @property coordinates a list of point coordinates forming a line
 */
@Serializable
@SerialName("LineString")
data class LineString(val coordinates: List<List<Double>>) : Geometry

/**
 * A GeoJSON MultiLineString geometry.
 * @property coordinates a list of LineStrings
 */
@Serializable
@SerialName("MultiLineString")
data class MultiLineString(val coordinates: List<List<List<Double>>>) : Geometry

/**
 * A GeoJSON Polygon geometry.
 * @property coordinates a list of linear rings, where the first is the exterior and others are holes
 */
@Serializable
@SerialName("Polygon")
data class Polygon(val coordinates: List<List<List<Double>>>) : Geometry

/**
 * A GeoJSON MultiPolygon geometry.
 * @property coordinates a list of polygons
 */
@Serializable
@SerialName("MultiPolygon")
data class MultiPolygon(val coordinates: List<List<List<List<Double>>>>) : Geometry
