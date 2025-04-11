package eu.verdelhan.cadastrefr

import eu.verdelhan.cadastrefr.model.BatimentFeatureCollection
import eu.verdelhan.cadastrefr.model.ParcelleFeatureCollection
import eu.verdelhan.cadastrefr.model.TsurfFeatureCollection
import eu.verdelhan.cadastrefr.model.AdresseFeatureCollection
import kotlinx.serialization.json.Json

/**
 * Parser for French cadastre JSON data.
 * This class provides methods to parse different cadastral feature collections.
 */
class FrenchCadastreParser {

    /** JSON configuration */
    val json = Json {
        ignoreUnknownKeys = true
    }

    /**
     * Parses a JSON string into the specified type.
     *
     * @param T The type to parse into.
     * @param jsonString The JSON string to parse.
     * @return The parsed object of type T.
     */
    inline fun <reified T> parseJson(jsonString: String): T {
        return json.decodeFromString(jsonString)
    }

    /**
     * Parses a JSON string into a [ParcelleFeatureCollection].
     *
     * @param jsonString The JSON string containing parcel data.
     * @return A [ParcelleFeatureCollection] object.
     */
    fun parseParcellesJson(jsonString: String): ParcelleFeatureCollection {
        return parseJson(jsonString)
    }

    /**
     * Parses a JSON string into a [BatimentFeatureCollection].
     *
     * @param jsonString The JSON string containing building data.
     * @return A [BatimentFeatureCollection] object.
     */
    fun parseBatimentsJson(jsonString: String): BatimentFeatureCollection {
        return parseJson(jsonString)
    }

    /**
     * Parses a JSON string into a [TsurfFeatureCollection].
     *
     * @param jsonString The JSON string containing topographic surface data.
     * @return A [TsurfFeatureCollection] object.
     */
    fun parsePciTsurfJson(jsonString: String): TsurfFeatureCollection {
        return parseJson(jsonString)
    }

    /**
     * Parses a JSON string into a [AdresseFeatureCollection].
     *
     * @param jsonString The JSON string containing address data.
     * @return A [AdresseFeatureCollection] object.
     */
    fun parseAdressesJson(jsonString: String): AdresseFeatureCollection {
        return parseJson(jsonString)
    }
}
