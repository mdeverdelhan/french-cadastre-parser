
import eu.verdelhan.cadastrefr.model.BatimentFeatureCollection
import eu.verdelhan.cadastrefr.model.ParcelleFeatureCollection
import eu.verdelhan.cadastrefr.model.TsurfFeatureCollection
import kotlinx.serialization.json.Json

/**
 * Parser for French cadastre
 */
class FrenchCadastreParser {

    val json = Json {
        ignoreUnknownKeys = true
    }

    inline fun <reified T> parseJson(jsonString: String): T {
        return json.decodeFromString(jsonString)
    }

    fun parseParcellesJson(jsonString: String): ParcelleFeatureCollection {
        return parseJson(jsonString)
    }

    fun parseBatimentsJson(jsonString: String): BatimentFeatureCollection {
        return parseJson(jsonString)
    }

    fun parsePciTsurfJson(jsonString: String): TsurfFeatureCollection {
        return parseJson(jsonString)
    }
}