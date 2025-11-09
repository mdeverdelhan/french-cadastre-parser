# french-cadastre-parser

`french-cadastre-parser` is a Kotlin library (Java compatible) designed to parse French cadastral plan data. It is distributed under the MIT license.

## Introduction

`french-cadastre-parser` provides an easy way to deserialize JSON data from the French cadastral system into Kotlin objects. It is lightweight and simple to use, ensuring compatibility with both Kotlin and Java projects.

## Features

- JSON parsing for French cadastral data
- Support for parcels, buildings, and topographic surfaces (Tsurf)
- Kotlin and Java compatibility
- Lightweight and easy to integrate
- MIT License

## Installation

`french-cadastre-parser` is available on [Maven Central](https://central.sonatype.com/artifact/eu.verdelhan/french-cadastre-parser). To use it in your project, add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>eu.verdelhan</groupId>
    <artifactId>french-cadastre-parser</artifactId>
    <version>1.3</version>
</dependency>
```

## Usage Examples

### Basic Usage in Kotlin

```kotlin
val json = File("/path/to/file/cadastre-parcelles.json").readText()
val parser = FrenchCadastreParser()
val parcelles: FeatureCollection<ParcelleProperties> = parser.parseParcellesJson(json)

println("14th parcel ID: ${parcelles.features[13].id}")
println("Third parcel area: ${parcelles.features[2].properties.contenance}")
```

### Basic Usage in Java

```java
FrenchCadastreParser parser = new FrenchCadastreParser();
String json = Files.readString(Path.of("/path/to/file/cadastre-parcelles.json"));
FeatureCollection<ParcelleProperties> parcelles = parser.parseParcellesJson(json);

System.out.println("Total parcels: " + parcelles.getFeatures().size());
System.out.println("Third parcel area: " + parcelles.getFeatures().get(2).getProperties().getContenance());
```

## About French Cadastral Data

The French cadastral system provides detailed geographic data about land parcels, buildings, and surface details. This data is publicly available and commonly used for real estate, mapping, and land management purposes.

## Disclaimer

This library is provided "as is" without any guarantees. The structure of French cadastral JSON data may change over time, requiring updates to this library.

## Notes

### Releases

```bash
mvn release:prepare
mvn release:perform
```

### Contributions

Contributions in the form of pull requests are welcome. For significant changes, please open an issue first to discuss your proposal.

## License

This project is distributed under the MIT License. See the [LICENSE](LICENSE) file for more details.

